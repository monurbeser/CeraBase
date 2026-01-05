package com.cerabase.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchHistoryDao {

    @Insert
    suspend fun insertSearchQuery(searchHistoryEntity: SearchHistoryEntity)

    @Query("SELECT * FROM search_history ORDER BY timestamp DESC LIMIT 10")
    fun getRecentSearches(): Flow<List<SearchHistoryEntity>>

    @Query("SELECT DISTINCT query FROM search_history ORDER BY timestamp DESC LIMIT 20")
    fun getUniqueSearchQueries(): Flow<List<String>>

    @Query("DELETE FROM search_history WHERE id = :id")
    suspend fun deleteSearchHistory(id: Long)

    @Query("DELETE FROM search_history")
    suspend fun clearAllSearchHistory()
}
