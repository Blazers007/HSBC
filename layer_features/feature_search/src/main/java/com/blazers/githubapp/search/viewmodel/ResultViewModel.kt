package com.blazers.githubapp.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.blazers.githubapp.search.model.ItemModel
import com.blazers.githubapp.search.repository.ResultRepository
import com.blazers.githubapp.search.repository.paging.PAGE_SIZE
import kotlinx.coroutines.flow.Flow

class ResultViewModel(
    private val repository: ResultRepository
) : ViewModel() {

    val items: Flow<PagingData<ItemModel>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
        pagingSourceFactory = { repository.source() }
    ).flow.cachedIn(viewModelScope)
}

class ResultViewModelFactory(
    private val repository: ResultRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(repository) as T
        }
        throw IllegalArgumentException()
    }
}
