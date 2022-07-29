package com.blazers.githubapp.search.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.blazers.githubapp.common.base.BaseDialogFragment
import com.blazers.githubapp.search.activity.KEY_QUERY
import com.blazers.githubapp.search.activity.ResultActivity
import com.blazers.githubapp.search.adapter.QueryRecordAdapter
import com.blazers.githubapp.search.database.SearchDatabase
import com.blazers.githubapp.search.databinding.FragmentQueryInputBinding
import com.blazers.githubapp.search.repository.QueryRepository
import com.blazers.githubapp.search.viewmodel.QueryViewModel
import com.blazers.githubapp.search.viewmodel.QueryViewModelFactory
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class QueryInputFragment : BaseDialogFragment<FragmentQueryInputBinding>(FragmentQueryInputBinding::inflate) {

    private val queryViewModel: QueryViewModel by viewModels {
        QueryViewModelFactory(QueryRepository(SearchDatabase.getDataBase(requireContext()).queryDao()))
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreate() {
        viewBinding.root.setOnClickListener { dismiss() }
        initInput()
        initRecyclerview()
    }

    private fun initInput() {
        viewBinding.etSearchEntrance.setOnEditorActionListener { _, actionId, _ ->
            val query = viewBinding.etSearchEntrance.text?.toString()?.trim()
            if (!query.isNullOrEmpty() && actionId == EditorInfo.IME_ACTION_SEARCH) {
                startQuery(query)
                viewBinding.etSearchEntrance.text = null
                return@setOnEditorActionListener true
            }
            false
        }
        viewBinding.etSearchEntrance.post {
            viewBinding.etSearchEntrance.requestFocus()
            val inputManager: InputMethodManager =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.showSoftInput(viewBinding.etSearchEntrance, 0)
        }
    }

    private fun initRecyclerview() {
        val adapter = QueryRecordAdapter { startQuery(it) }
        viewBinding.recyclerview.adapter = adapter
        viewBinding.recyclerview.layoutManager = FlexboxLayoutManager(requireContext()).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                queryViewModel.queryRecordList.collectLatest {
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun startQuery(query: String) {
        if (query.isEmpty()) {
            return
        }
        startActivity(
            Intent(requireContext(), ResultActivity::class.java).putExtra(
                KEY_QUERY, query
            )
        )
        lifecycleScope.launch {
            queryViewModel.addQueryRecord(query)
        }
    }
}