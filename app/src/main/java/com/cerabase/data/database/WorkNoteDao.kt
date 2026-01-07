package com.cerabase.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkNoteDao {

    @Query("SELECT * FROM work_notes ORDER BY date DESC, createdAt DESC")
    fun getAllNotes(): Flow<List<WorkNoteEntity>>

    @Query("SELECT * FROM work_notes WHERE date = :date ORDER BY createdAt ASC")
    fun getNotesByDate(date: Long): Flow<List<WorkNoteEntity>>

    @Query("SELECT * FROM work_notes WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC, createdAt ASC")
    fun getNotesForDateRange(startDate: Long, endDate: Long): Flow<List<WorkNoteEntity>>

    @Query("SELECT DISTINCT date FROM work_notes ORDER BY date DESC")
    fun getAllDates(): Flow<List<Long>>

    @Query("SELECT * FROM work_notes WHERE id = :id")
    suspend fun getNoteById(id: Long): WorkNoteEntity?

    @Insert
    suspend fun insertNote(note: WorkNoteEntity): Long

    @Update
    suspend fun updateNote(note: WorkNoteEntity)

    @Delete
    suspend fun deleteNote(note: WorkNoteEntity)

    @Query("DELETE FROM work_notes WHERE id = :id")
    suspend fun deleteNoteById(id: Long)
}
