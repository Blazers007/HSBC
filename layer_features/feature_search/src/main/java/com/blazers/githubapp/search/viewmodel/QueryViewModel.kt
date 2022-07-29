package com.blazers.githubapp.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.blazers.githubapp.search.database.entity.QueryRecord
import com.blazers.githubapp.search.repository.QueryRepository
import com.blazers.githubapp.search.repository.ResultRepository
import kotlinx.coroutines.launch

class QueryViewModel(
    private val queryRepository: QueryRepository
) : ViewModel() {

    val queryRecordList = queryRepository.queryRecordList

    fun addQueryRecord(query: String) = viewModelScope.launch {
        queryRepository.addQueryRecord(QueryRecord(query, System.currentTimeMillis()))
    }
}

class QueryViewModelFactory(
    private val repository: QueryRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QueryViewModel::class.java)) {
            return QueryViewModel(repository) as T
        }
        throw IllegalArgumentException()
    }
}
