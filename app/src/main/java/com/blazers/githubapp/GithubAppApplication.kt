package com.blazers.githubapp

import android.app.Application
import com.blazers.githubapp.common.util.UserHelper
import com.blazers.githubapp.network.Network
import okhttp3.Interceptor

class GithubAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        UserHelper.initialize(this)
        Network.userInterceptor = Interceptor { chain ->
            UserHelper.getToken()?.takeIf { it.isNotBlank() }?.let {
                val request = chain.request().newBuilder()
                    .addHeader("Authorization: token ", it)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            return@Interceptor chain.proceed(chain.request())
        }
    }
}