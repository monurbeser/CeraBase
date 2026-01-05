package com.cerabase.data.repository

import com.cerabase.data.database.CustomClayFormulaDao
import com.cerabase.data.database.CustomClayFormulaEntity
import kotlinx.coroutines.flow.Flow

class CustomClayFormulaRepository(private val customClayFormulaDao: CustomClayFormulaDao) {

    fun getAllCustomFormulas(): Flow<List<CustomClayFormulaEntity>> {
        return customClayFormulaDao.getAllCustomFormulas()
    }

    fun getCustomFormulasByType(type: String): Flow<List<CustomClayFormulaEntity>> {
        return customClayFormulaDao.getCustomFormulasByType(type)
    }

    suspend fun getCustomFormulaById(id: Long): CustomClayFormulaEntity? {
        return customClayFormulaDao.getCustomFormulaById(id)
    }

    suspend fun getCustomFormulaCount(): Int {
        return customClayFormulaDao.getCustomFormulaCount()
    }

    suspend fun addCustomFormula(
        name: String,
        type: String,
        cone: String,
        ingredients: String,
        notes: String = "",
        properties: String = ""
    ): Long {
        val formula = CustomClayFormulaEntity(
            name = name,
            type = type,
            cone = cone,
            ingredients = ingredients,
            notes = notes,
            properties = properties
        )
        return customClayFormulaDao.insertCustomFormula(formula)
    }

    suspend fun updateCustomFormula(
        id: Long,
        name: String,
        type: String,
        cone: String,
        ingredients: String,
        notes: String,
        properties: String
    ) {
        val formula = CustomClayFormulaEntity(
            id = id,
            name = name,
            type = type,
            cone = cone,
            ingredients = ingredients,
            notes = notes,
            properties = properties,
            updatedAt = System.currentTimeMillis()
        )
        customClayFormulaDao.updateCustomFormula(formula)
    }

    suspend fun deleteCustomFormula(id: Long) {
        customClayFormulaDao.deleteCustomFormulaById(id)
    }

    suspend fun deleteAllCustomFormulas() {
        customClayFormulaDao.deleteAllCustomFormulas()
    }
}
