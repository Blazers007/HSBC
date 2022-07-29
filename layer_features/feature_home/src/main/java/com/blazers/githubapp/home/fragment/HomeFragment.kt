package com.blazers.githubapp.home.fragment

import com.blazers.githubapp.common.base.BaseFragment
import com.blazers.githubapp.home.R
import com.blazers.githubapp.home.databinding.FragmentHomeBinding
import com.blazers.githubapp.login.fragment.LoginFragment
import com.blazers.githubapp.search.fragment.SearchFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreate() {
        childFragmentManager.beginTransaction()
            .replace(R.id.container_search, SearchFragment.newInstance())
            .replace(R.id.container_login, LoginFragment.newInstance())
            .commit()
    }
}