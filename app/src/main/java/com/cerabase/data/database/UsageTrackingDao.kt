package com.cerabase.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UsageTrackingDao {

    @Query("SELECT * FROM usage_tracking ORDER BY viewCount DESC, lastViewedAt DESC LIMIT :limit")
    fun getMostViewedItems(limit: Int = 50): Flow<List<UsageTrackingEntity>>

    @Query("SELECT * FROM usage_tracking WHERE category = :category ORDER BY viewCount DESC LIMIT :limit")
    fun getMostViewedItemsByCategory(category: String, limit: Int = 20): Flow<List<UsageTrackingEntity>>

    @Query("SELECT * FROM usage_tracking WHERE itemId = :itemId LIMIT 1")
    suspend fun getUsageInfo(itemId: String): UsageTrackingEntity?

    @Query("SELECT viewCount FROM usage_tracking WHERE itemId = :itemId")
    fun getViewCount(itemId: String): Flow<Int?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUsageTracking(tracking: UsageTrackingEntity)

    @Query("""
        UPDATE usage_tracking
        SET viewCount = viewCount + 1, lastViewedAt = :timestamp
        WHERE itemId = :itemId
    """)
    suspend fun incrementViewCount(itemId: String, timestamp: Long = System.currentTimeMillis())

    @Update
    suspend fun updateUsageTracking(tracking: UsageTrackingEntity)

    @Query("DELETE FROM usage_tracking")
    suspend fun deleteAllUsageTracking()
}
