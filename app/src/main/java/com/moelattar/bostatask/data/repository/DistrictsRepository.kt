package com.moelattar.bostatask.data.repository

import android.util.Log
import com.moelattar.bostatask.data.mappers.CitiesMapper
import com.moelattar.bostatask.domain.models.City
import com.moelattar.bostatask.domain.repository.IDistrictsRepository
import com.moelattar.bostatask.domain.repository.remote.IDistrictsRemoteDS
import javax.inject.Inject

class DistrictsRepository @Inject constructor(
    private val remoteDS: IDistrictsRemoteDS,
) : IDistrictsRepository {
    override suspend fun getAllCities(): List<City>? {
        Log.d("CitiesREP", remoteDS.getAllCities().toString())
        val cityList = remoteDS.getAllCities().citiesList
        Log.d("CitiesREP", cityList.toString())
        return cityList?.map {
            CitiesMapper.dtoToDomain(it!!)
        }
    }

}