package com.blazers.githubapp.search.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blazers.githubapp.search.database.entity.QueryRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface QueryDao {

    @Query("SELECT * FROM query_record_table ORDER BY timestamp DESC LIMIT 30")
    fun getQueryRecord(): Flow<List<QueryRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(queryEntity: QueryRecord)
}