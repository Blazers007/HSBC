package com.blazers.githubapp.search.repository

import com.blazers.githubapp.search.database.dao.QueryDao
import com.blazers.githubapp.search.database.entity.QueryRecord
import kotlinx.coroutines.flow.Flow

class QueryRepository(private val dao: QueryDao) {

    val queryRecordList: Flow<List<QueryRecord>> = dao.getQueryRecord()

    suspend fun addQueryRecord(query: QueryRecord) {
        dao.insert(query)
    }
}