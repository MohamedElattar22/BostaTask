package com.moelattar.bostatask.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.moelattar.bostatask.common.data.models.Resource
import com.moelattar.bostatask.common.viewmodel.BostaTaskViewModel
import com.moelattar.bostatask.common.viewmodel.ViewAction
import com.moelattar.bostatask.domain.usecases.remote.GetAllCitiesFromRemoteUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val getAllCitiesFromRemoteUC: GetAllCitiesFromRemoteUC,
) : BostaTaskViewModel<CitiesContract.CitiesActions, CitiesContract.CitiesEvents, CitiesContract.CitiesState>(
    CitiesContract.CitiesState.initial()
) {
    init {

        onActionTrigger(CitiesContract.CitiesActions.GetAllCities)
    }

    override fun clearState() {
        setState(CitiesContract.CitiesState.initial())
    }

    override fun onActionTrigger(action: ViewAction?) {
        setState(oldViewState.copy(action = action))
        when (action) {
            is CitiesContract.CitiesActions.GetAllCities -> getAllCities()
            is CitiesContract.CitiesActions.SetLoading -> {
                setLoading(action.isLoading)

            }

            is CitiesContract.CitiesActions.FilterCitiesByName -> {
                filterCitiesByName(action.cityName)
            }

            is CitiesContract.CitiesActions.OnQueryChange -> {
                setState(oldViewState.copy(query = action.query))
            }


        }

    }

    private fun setLoading(loading: Boolean) {
        setState(oldViewState.copy(isLoading = loading))
    }

    private fun getAllCities() {
        getAllCitiesFromRemoteUC.invoke(viewModelScope) { result ->
            when (result) {
                is Resource.Failure -> {
                    setState(oldViewState.copy(exception = result.exception))
                    sendEvent(CitiesContract.CitiesEvents.ErrorLoadingCities)
                }

                is Resource.Progress -> {
                    setState(oldViewState.copy(isLoading = result.loading))
                }

                is Resource.Success -> {
                    setState(oldViewState.copy(cities = result.model!!))
                    sendEvent(CitiesContract.CitiesEvents.CitiesLoadedSuccessfully)
                    Log.d("citieas", result.model.toString())
                }
            }

        }
    }

    private fun filterCitiesByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val filteredCities = oldViewState.cities.filter {
                it.cityName.contains(name, ignoreCase = true)
            }
            ensureActive()
            setState(oldViewState.copy(cities = filteredCities))
        }
    }
}