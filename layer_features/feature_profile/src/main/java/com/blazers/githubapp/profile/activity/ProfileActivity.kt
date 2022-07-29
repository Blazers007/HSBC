package com.blazers.githubapp.profile.activity

import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.blazers.githubapp.common.base.BaseActivity
import com.blazers.githubapp.imageloader.ext.loadImage
import com.blazers.githubapp.profile.databinding.ActivityProfileBinding
import com.blazers.githubapp.profile.repository.ProfileRepository
import com.blazers.githubapp.profile.viewmodel.ProfileViewModel
import com.blazers.githubapp.profile.viewmodel.ProfileViewModelFactory
import kotlinx.coroutines.launch

const val KEY_USER = "user"

class ProfileActivity : BaseActivity<ActivityProfileBinding>(ActivityProfileBinding::inflate) {

    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory(ProfileRepository())
    }

    override fun onCreate() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                profileViewModel.getProfile(intent.getStringExtra(KEY_USER) ?: "").collect {
                    viewBinding.rivAvatar.loadImage(it.avatar_url)
                    viewBinding.tvUsername.text = it.name
                    viewBinding.tvBio.text = it.bio
                    viewBinding.tvFollowers.text = it.followers.toString()
                    viewBinding.tvFollowing.text = it.following.toString()
                }
            }
        }
    }
}