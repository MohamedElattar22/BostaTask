package com.moelattar.bostatask.domain.repository

import com.moelattar.bostatask.domain.models.City

interface IDistrictsRepository {

    suspend fun getAllCities(): List<City>?

}