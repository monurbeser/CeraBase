package com.cerabase.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work_notes")
data class WorkNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Long, // Selected date in milliseconds (day start)
    val description: String,
    val imageUris: String = "", // Comma-separated URIs of images
    val createdAt: Long = System.currentTimeMillis()
)
