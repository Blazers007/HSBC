package com.blazers.githubapp.login.fragment

import android.content.Intent
import com.blazers.githubapp.common.base.BaseFragment
import com.blazers.githubapp.imageloader.ext.loadImage
import com.blazers.githubapp.login.databinding.FragmentLoginBinding
import com.blazers.githubapp.profile.activity.KEY_USER
import com.blazers.githubapp.profile.activity.ProfileActivity

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreate() {
        viewBinding.ivAvatar.loadImage(
            "https://avatars.githubusercontent.com/u/8711418?v=4"
        )
        viewBinding.ivAvatar.setOnClickListener {
            startActivity(
                Intent(requireContext(), ProfileActivity::class.java)
                    .putExtra(KEY_USER, "blazers007")
            )
        }
    }
}