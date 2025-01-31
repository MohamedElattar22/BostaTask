package com.moelattar.bostatask.common.di

import com.moelattar.bostatask.common.data.repository.remote.call_factory.BostaTaskCallAdapterFactory
import com.moelattar.bostatask.common.data.repository.remote.converter.ExceptionConverter
import com.moelattar.bostatask.common.data.repository.remote.converter.IExceptionConverter
import com.moelattar.bostatask.common.domain.repository.remote.INetworkProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory,
        bostaTaskCallAdapterFactory: BostaTaskCallAdapterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl("https://stg-app.bosta.co/api/v2/cities/")
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(bostaTaskCallAdapterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideOneClickApiService(retrofit: Retrofit): INetworkProvider =
        retrofit.create(INetworkProvider::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient.Builder {
        return OkHttpClient().newBuilder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            connectionPool(
                ConnectionPool(30L.toInt(), 500000, TimeUnit.MILLISECONDS)
            )
            readTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
            addInterceptor(httpLoggingInterceptor)

            // Add custom interceptor for debugging response
            addInterceptor { chain ->
                val request = chain.request()
                val response = chain.proceed(request)

                // Log the raw response body
                val rawResponse = response.body?.string()
                println("Raw API Response: $rawResponse")

                // Return the response to Retrofit after logging
                response.newBuilder()
                    .body(rawResponse?.toResponseBody(response.body?.contentType()))
                    .build()
            }
        }
    }


    @Provides
    @Singleton
    fun provideCallAdapter(exceptionConverter: IExceptionConverter): BostaTaskCallAdapterFactory {
        return BostaTaskCallAdapterFactory.create(exceptionConverter)
    }

    @Provides
    @Singleton
    fun provideExceptionConverter(): IExceptionConverter {
        return ExceptionConverter()
    }


    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor { message ->
            println(message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}