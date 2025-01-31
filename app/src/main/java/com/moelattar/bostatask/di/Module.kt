package com.moelattar.bostatask.di

import com.moelattar.bostatask.common.domain.repository.remote.INetworkProvider
import com.moelattar.bostatask.data.repository.DistrictsRepository
import com.moelattar.bostatask.data.repository.remote.DistrictsRemoteDS
import com.moelattar.bostatask.domain.repository.IDistrictsRepository
import com.moelattar.bostatask.domain.repository.remote.IDistrictsRemoteDS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun providesDistrictsRemoteDS(
        networkProvider: INetworkProvider,
    ): IDistrictsRemoteDS {
        return DistrictsRemoteDS(networkProvider)
    }

    @Provides
    fun providesDistrictsRepository(
        districtsRemoteDS: IDistrictsRemoteDS,
    ): IDistrictsRepository {
        return DistrictsRepository(districtsRemoteDS)

    }
//
}