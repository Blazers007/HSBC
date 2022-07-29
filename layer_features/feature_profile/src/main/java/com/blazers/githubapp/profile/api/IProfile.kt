package com.blazers.githubapp.profile.api

import com.blazers.githubapp.model.user.UserModel
import retrofit2.http.GET
import retrofit2.http.Path

interface IProfile {

    @GET("users/{user}")
    suspend fun getProfile(
         @Path("user") user: String
    ): UserModel

}