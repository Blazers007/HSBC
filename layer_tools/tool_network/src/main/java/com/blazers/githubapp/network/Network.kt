package com.blazers.githubapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

    var userInterceptor: Interceptor? = null

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .apply {
                userInterceptor?.let { addInterceptor(it) }
            }
            .build()
    }

    fun <T> getService(
        baseUrl: String,
        service: Class<T>
    ): T {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .build()
            .create(service)
    }
}