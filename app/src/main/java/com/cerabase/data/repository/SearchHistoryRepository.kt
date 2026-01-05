package com.cerabase.data.repository

import com.cerabase.data.database.SearchHistoryDao
import com.cerabase.data.database.SearchHistoryEntity
import kotlinx.coroutines.flow.Flow

class SearchHistoryRepository(private val searchHistoryDao: SearchHistoryDao) {

    fun getRecentSearches(): Flow<List<SearchHistoryEntity>> {
        return searchHistoryDao.getRecentSearches()
    }

    fun getUniqueSearchQueries(): Flow<List<String>> {
        return searchHistoryDao.getUniqueSearchQueries()
    }

    suspend fun addSearchQuery(query: String) {
        searchHistoryDao.insertSearchQuery(
            SearchHistoryEntity(query = query)
        )
    }

    suspend fun deleteSearchHistory(id: Long) {
        searchHistoryDao.deleteSearchHistory(id)
    }

    suspend fun clearAllSearchHistory() {
        searchHistoryDao.clearAllSearchHistory()
    }
}
