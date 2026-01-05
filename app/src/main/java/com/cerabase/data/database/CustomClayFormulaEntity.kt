package com.cerabase.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "custom_clay_formulas")
data class CustomClayFormulaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val type: String, // "Porcelain", "Stoneware", "Earthenware", "Custom"
    val cone: String, // "6-8", "8-10", etc.
    val ingredients: String, // JSON formatted ingredients: "kaolin:25,feldspar:30,silica:35,ball_clay:10"
    val notes: String = "", // User notes
    val properties: String = "", // User-defined properties
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
