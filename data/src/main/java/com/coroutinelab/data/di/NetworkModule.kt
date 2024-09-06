package com.coroutinelab.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

object NetworkModule {

    private val networkJson = Json { ignoreUnknownKeys = true }

    @Provides
    fun provideBaseUrl() = "https://66d8348537b1cadd8053cedf.mockapi.io/"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    @Singleton
    @Provides
    fun provideRetrofit(url: String): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()

}