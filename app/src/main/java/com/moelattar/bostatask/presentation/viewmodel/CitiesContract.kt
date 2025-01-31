package com.moelattar.bostatask.presentation.viewmodel

import com.moelattar.bostatask.common.data.models.exception.BostaTaskException
import com.moelattar.bostatask.common.viewmodel.ViewAction
import com.moelattar.bostatask.common.viewmodel.ViewEvent
import com.moelattar.bostatask.common.viewmodel.ViewState
import com.moelattar.bostatask.domain.models.City

interface CitiesContract {
    sealed class CitiesActions : ViewAction {
        data object GetAllCities : CitiesActions()
        data class SetLoading(val isLoading: Boolean) : CitiesActions()
        data class FilterCitiesByName(val cityName: String) : CitiesActions()
        data class OnQueryChange(val query: String) : CitiesActions()
    }

    sealed class CitiesEvents : ViewEvent {
        data class ShowToast(val message: String) : CitiesEvents()
        data object CitiesLoadedSuccessfully : CitiesEvents()
        data object ErrorLoadingCities : CitiesEvents()
    }

    data class CitiesState(
        val isLoading: Boolean = false,
        val exception: BostaTaskException? = null,
        val action: ViewAction? = null,
        val cities: List<City> = emptyList(),
        val query: String = "",
    ) : ViewState {
        companion object {
            fun initial() = CitiesState(
                isLoading = false,
                exception = null,
                action = null
            )
        }
    }

}