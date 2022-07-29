package com.blazers.githubapp.search.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blazers.githubapp.search.database.dao.QueryDao
import com.blazers.githubapp.search.database.entity.QueryRecord

@Database(
    entities = [QueryRecord::class],
    version = 1
)
abstract class SearchDatabase : RoomDatabase() {

    abstract fun queryDao(): QueryDao

    companion object {
        @Volatile
        private var INSTANCE: SearchDatabase? = null

        fun getDataBase(
            context: Context,
        ): SearchDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SearchDatabase::class.java,
                    "search_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}