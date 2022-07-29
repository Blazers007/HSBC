package com.blazers.githubapp.model.user

data class UserModel(
    val name: String,
    val avatar_url: String,
    val bio: String,
    val following: Int,
    val followers: Int
)
