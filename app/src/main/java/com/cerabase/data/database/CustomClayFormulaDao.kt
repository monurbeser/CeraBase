package com.cerabase.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomClayFormulaDao {

    @Query("SELECT * FROM custom_clay_formulas ORDER BY createdAt DESC")
    fun getAllCustomFormulas(): Flow<List<CustomClayFormulaEntity>>

    @Query("SELECT * FROM custom_clay_formulas WHERE type = :type ORDER BY createdAt DESC")
    fun getCustomFormulasByType(type: String): Flow<List<CustomClayFormulaEntity>>

    @Query("SELECT * FROM custom_clay_formulas WHERE id = :id LIMIT 1")
    suspend fun getCustomFormulaById(id: Long): CustomClayFormulaEntity?

    @Query("SELECT COUNT(*) FROM custom_clay_formulas")
    suspend fun getCustomFormulaCount(): Int

    @Insert
    suspend fun insertCustomFormula(formula: CustomClayFormulaEntity): Long

    @Update
    suspend fun updateCustomFormula(formula: CustomClayFormulaEntity)

    @Delete
    suspend fun deleteCustomFormula(formula: CustomClayFormulaEntity)

    @Query("DELETE FROM custom_clay_formulas WHERE id = :id")
    suspend fun deleteCustomFormulaById(id: Long)

    @Query("DELETE FROM custom_clay_formulas")
    suspend fun deleteAllCustomFormulas()
}
