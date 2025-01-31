package com.moelattar.bostatask.domain.usecases.remote

import com.moelattar.bostatask.common.interactor.BaseUseCase
import com.moelattar.bostatask.domain.models.City
import com.moelattar.bostatask.domain.repository.IDistrictsRepository
import javax.inject.Inject

class GetAllCitiesFromRemoteUC @Inject constructor(
    private val repository: IDistrictsRepository,
) : BaseUseCase<List<City>?, Unit>() {
    override suspend fun execute(params: Unit?): List<City>? {
        return repository.getAllCities()
    }

}