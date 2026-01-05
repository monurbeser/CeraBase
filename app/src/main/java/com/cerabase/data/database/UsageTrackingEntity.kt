package com.cerabase.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usage_tracking")
data class UsageTrackingEntity(
    @PrimaryKey
    val itemId: String, // Unique ID for the item (e.g., "cone_5", "oxide_iron", "formula_porcelain")
    val category: String, // Category type: "seger_cones", "expansion", "oxides", "clay_formulas", "troubleshooting"
    val viewCount: Int = 0,
    val lastViewedAt: Long = System.currentTimeMillis()
)
