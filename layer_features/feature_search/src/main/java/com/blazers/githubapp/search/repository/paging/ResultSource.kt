package com.blazers.githubapp.search.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.blazers.githubapp.search.api.ISearchService
import com.blazers.githubapp.search.model.ItemModel

const val START_PAGE = 1
const val PAGE_SIZE = 30

class ResultSource(
    private val query: String,
    private val searchService: ISearchService
) : PagingSource<Int, ItemModel>() {

    override fun getRefreshKey(state: PagingState<Int, ItemModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemModel> {
        val page = params.key ?: START_PAGE
        return try {
            val result = searchService.search(query, page)
            val hasMore = result.total_count > (page - 1) * PAGE_SIZE + result.items.size
            LoadResult.Page(
                data = result.items,
                prevKey = if (page != START_PAGE) page else null,
                nextKey = if (hasMore) page + 1 else null
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}