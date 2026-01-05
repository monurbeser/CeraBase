package com.cerabase.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val itemId: String,           // Unique ID for the item (e.g., "cone_5", "oxide_iron", "formula_porcelain")
    val category: String,          // Category type: "seger_cones", "expansion", "oxides", "clay_formulas", "troubleshooting"
    val title: String,             // Display title
    val subtitle: String = "",     // Optional subtitle/description
    val timestamp: Long = System.currentTimeMillis()
)
