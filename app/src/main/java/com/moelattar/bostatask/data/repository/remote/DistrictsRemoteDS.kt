package com.moelattar.bostatask.data.repository.remote

import com.moelattar.bostatask.common.domain.repository.remote.INetworkProvider
import com.moelattar.bostatask.data.model.AreaResponse
import com.moelattar.bostatask.domain.repository.remote.IDistrictsRemoteDS
import javax.inject.Inject

class DistrictsRemoteDS @Inject constructor(
    private val networkProvider: INetworkProvider,
) : IDistrictsRemoteDS {
    override suspend fun getAllCities(): AreaResponse {
        return networkProvider.getAllCities()
    }

}