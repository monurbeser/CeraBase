package com.cerabase.data.repository

import com.cerabase.data.database.FavoriteDao
import com.cerabase.data.database.FavoriteEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val favoriteDao: FavoriteDao) {

    fun getAllFavorites(): Flow<List<FavoriteEntity>> {
        return favoriteDao.getAllFavorites()
    }

    fun getFavoritesByCategory(category: String): Flow<List<FavoriteEntity>> {
        return favoriteDao.getFavoritesByCategory(category)
    }

    fun isFavorite(itemId: String): Flow<Boolean> {
        return favoriteDao.isFavorite(itemId)
    }

    suspend fun toggleFavorite(
        itemId: String,
        category: String,
        title: String,
        subtitle: String = ""
    ) {
        val existing = favoriteDao.getFavoriteByItemId(itemId)
        if (existing != null) {
            favoriteDao.deleteFavoriteByItemId(itemId)
        } else {
            favoriteDao.insertFavorite(
                FavoriteEntity(
                    itemId = itemId,
                    category = category,
                    title = title,
                    subtitle = subtitle
                )
            )
        }
    }

    suspend fun addFavorite(
        itemId: String,
        category: String,
        title: String,
        subtitle: String = ""
    ) {
        favoriteDao.insertFavorite(
            FavoriteEntity(
                itemId = itemId,
                category = category,
                title = title,
                subtitle = subtitle
            )
        )
    }

    suspend fun removeFavorite(itemId: String) {
        favoriteDao.deleteFavoriteByItemId(itemId)
    }

    suspend fun clearAllFavorites() {
        favoriteDao.deleteAllFavorites()
    }
}
