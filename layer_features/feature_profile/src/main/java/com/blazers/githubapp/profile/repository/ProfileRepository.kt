package com.blazers.githubapp.profile.repository

import com.blazers.githubapp.contants.BASE_API
import com.blazers.githubapp.model.user.UserModel
import com.blazers.githubapp.network.Network
import com.blazers.githubapp.profile.api.IProfile

class ProfileRepository {

    private val service by lazy { Network.getService(BASE_API, IProfile::class.java) }

    suspend fun loadProfile(user: String) : UserModel {
        return service.getProfile(user)
    }
}