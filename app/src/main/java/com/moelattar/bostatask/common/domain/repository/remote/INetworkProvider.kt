package com.moelattar.bostatask.common.domain.repository.remote

import com.moelattar.bostatask.data.model.AreaResponse
import retrofit2.http.GET

interface INetworkProvider {

    @GET("getAllDistricts")
    suspend fun getAllCities(): AreaResponse

}