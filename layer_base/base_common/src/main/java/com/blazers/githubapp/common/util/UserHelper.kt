package com.blazers.githubapp.common.util

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

// https://yuweiguocn.github.io/androidx-security/
object UserHelper {

    private lateinit var sharedPreferences: SharedPreferences

    private const val KEY_TOKEN = "token"

    private var token: String? = null

    fun initialize(context: Context) {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        sharedPreferences = EncryptedSharedPreferences.create(
            "shared_preferences_filename",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun isLogin() = !getToken().isNullOrBlank()

    fun getToken() = token ?: sharedPreferences.getString(KEY_TOKEN, null)?.also { token = it }

    fun setToken(token: String) = sharedPreferences.edit().putString(KEY_TOKEN, token).apply().also {
        this.token = token
    }
}