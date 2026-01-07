package com.cerabase.data.repository

import com.cerabase.data.database.WorkNoteDao
import com.cerabase.data.database.WorkNoteEntity
import kotlinx.coroutines.flow.Flow

class WorkNoteRepository(private val workNoteDao: WorkNoteDao) {

    fun getAllNotes(): Flow<List<WorkNoteEntity>> {
        return workNoteDao.getAllNotes()
    }

    fun getNotesByDate(date: Long): Flow<List<WorkNoteEntity>> {
        return workNoteDao.getNotesByDate(date)
    }

    fun getNotesForDateRange(startDate: Long, endDate: Long): Flow<List<WorkNoteEntity>> {
        return workNoteDao.getNotesForDateRange(startDate, endDate)
    }

    fun getAllDates(): Flow<List<Long>> {
        return workNoteDao.getAllDates()
    }

    suspend fun getNoteById(id: Long): WorkNoteEntity? {
        return workNoteDao.getNoteById(id)
    }

    suspend fun addNote(date: Long, description: String, imageUris: String = ""): Long {
        val note = WorkNoteEntity(
            date = date,
            description = description,
            imageUris = imageUris
        )
        return workNoteDao.insertNote(note)
    }

    suspend fun updateNote(note: WorkNoteEntity) {
        workNoteDao.updateNote(note)
    }

    suspend fun deleteNote(note: WorkNoteEntity) {
        workNoteDao.deleteNote(note)
    }

    suspend fun deleteNoteById(id: Long) {
        workNoteDao.deleteNoteById(id)
    }
}
