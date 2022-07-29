package com.blazers.githubapp.search.fragment

import com.blazers.githubapp.common.base.BaseFragment
import com.blazers.githubapp.search.databinding.FragmentSearchBinding

private const val TAG = "QueryInputFragment"

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreate() {
        viewBinding.tvSearchEntrance.setOnClickListener {
            QueryInputFragment().show(childFragmentManager, TAG)
        }
    }
}