package com.blazers.githubapp.search.api

import com.blazers.githubapp.search.model.SearchResultModel
import retrofit2.http.GET
import retrofit2.http.Query

// https://docs.github.com/cn/rest/search
interface ISearchService {

    @GET("search/repositories")
    suspend fun search(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): SearchResultModel
}