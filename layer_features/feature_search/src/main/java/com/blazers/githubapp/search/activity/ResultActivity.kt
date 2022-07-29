package com.blazers.githubapp.search.activity

import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.blazers.githubapp.common.base.BaseActivity
import com.blazers.githubapp.search.R
import com.blazers.githubapp.search.adapter.ResultAdapter
import com.blazers.githubapp.search.databinding.ActivityResultBinding
import com.blazers.githubapp.search.repository.ResultRepository
import com.blazers.githubapp.search.viewmodel.ResultViewModel
import com.blazers.githubapp.search.viewmodel.ResultViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

const val KEY_QUERY = "query"

class ResultActivity : BaseActivity<ActivityResultBinding>(ActivityResultBinding::inflate) {

    private val viewModel: ResultViewModel by viewModels {
        ResultViewModelFactory(ResultRepository(intent.getStringExtra(KEY_QUERY) ?: ""))
    }

    private val adapter by lazy {
        ResultAdapter {
            // 跳转
        }
    }

    override fun onCreate() {
        title = "Search: " + intent.getStringExtra(KEY_QUERY)
        initProgressView()
        initRecyclerView()
    }

    private fun initProgressView() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.loadStateFlow.collect {
                    viewBinding.progressLoad.isVisible = it.source.refresh is LoadState.Loading
                    viewBinding.progressLoadMore.isVisible = it.source.append is LoadState.Loading
                    if (it.source.append.endOfPaginationReached) {
                        Snackbar.make(viewBinding.progressLoad, R.string.search_no_more, Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        viewBinding.recyclerview.adapter = adapter
        viewBinding.recyclerview.layoutManager = LinearLayoutManager(this)
        val items = viewModel.items
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                items.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}