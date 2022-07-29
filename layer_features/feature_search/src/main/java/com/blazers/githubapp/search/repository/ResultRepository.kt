package com.blazers.githubapp.search.repository

import com.blazers.githubapp.contants.BASE_API
import com.blazers.githubapp.network.Network
import com.blazers.githubapp.search.api.ISearchService
import com.blazers.githubapp.search.repository.paging.ResultSource

class ResultRepository(private val query: String) {

    private val service by lazy { Network.getService(BASE_API, ISearchService::class.java) }

    fun source() = ResultSource(query, service)

}