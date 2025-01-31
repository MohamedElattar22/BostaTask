package com.moelattar.bostatask.domain.repository.remote

import com.moelattar.bostatask.data.model.AreaResponse

interface IDistrictsRemoteDS {
    suspend fun getAllCities(): AreaResponse

}