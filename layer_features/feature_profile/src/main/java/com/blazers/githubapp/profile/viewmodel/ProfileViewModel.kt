package com.blazers.githubapp.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blazers.githubapp.model.user.UserModel
import com.blazers.githubapp.profile.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfileViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    fun getProfile(user: String): Flow<UserModel> = flow {
        emit(repository.loadProfile(user))
    }
}

class ProfileViewModelFactory(
    private val repository: ProfileRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        }
        throw IllegalArgumentException()
    }
}