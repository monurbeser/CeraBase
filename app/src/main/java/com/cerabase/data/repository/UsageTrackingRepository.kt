package com.cerabase.data.repository

import com.cerabase.data.database.UsageTrackingDao
import com.cerabase.data.database.UsageTrackingEntity
import kotlinx.coroutines.flow.Flow

class UsageTrackingRepository(private val usageTrackingDao: UsageTrackingDao) {

    fun getMostViewedItems(limit: Int = 50): Flow<List<UsageTrackingEntity>> {
        return usageTrackingDao.getMostViewedItems(limit)
    }

    fun getMostViewedItemsByCategory(category: String, limit: Int = 20): Flow<List<UsageTrackingEntity>> {
        return usageTrackingDao.getMostViewedItemsByCategory(category, limit)
    }

    suspend fun getUsageInfo(itemId: String): UsageTrackingEntity? {
        return usageTrackingDao.getUsageInfo(itemId)
    }

    fun getViewCount(itemId: String): Flow<Int?> {
        return usageTrackingDao.getViewCount(itemId)
    }

    suspend fun trackView(itemId: String, category: String) {
        val existing = usageTrackingDao.getUsageInfo(itemId)
        if (existing != null) {
            usageTrackingDao.incrementViewCount(itemId)
        } else {
            usageTrackingDao.insertUsageTracking(
                UsageTrackingEntity(
                    itemId = itemId,
                    category = category,
                    viewCount = 1
                )
            )
        }
    }

    suspend fun clearAllUsageTracking() {
        usageTrackingDao.deleteAllUsageTracking()
    }
}
