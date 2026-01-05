package com.cerabase.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        FavoriteEntity::class,
        CustomClayFormulaEntity::class,
        UsageTrackingEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CeraBaseDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
    abstract fun customClayFormulaDao(): CustomClayFormulaDao
    abstract fun usageTrackingDao(): UsageTrackingDao

    companion object {
        @Volatile
        private var INSTANCE: CeraBaseDatabase? = null

        fun getDatabase(context: Context): CeraBaseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CeraBaseDatabase::class.java,
                    "cerabase_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
