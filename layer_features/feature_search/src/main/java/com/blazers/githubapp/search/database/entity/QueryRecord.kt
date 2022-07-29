package com.blazers.githubapp.search.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "query_record_table")
data class QueryRecord(
    @PrimaryKey
    val query: String,
    val timestamp: Long
)