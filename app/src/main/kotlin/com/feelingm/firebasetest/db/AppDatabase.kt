package com.feelingm.firebasetest.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.feelingm.firebasetest.util.room.DatabaseTypeConverters

/**
 * Created by mac on 2018. 2. 23..
 */

@Database(entities = [ TaskListEntity::class ], version = 1)
@TypeConverters(DatabaseTypeConverters::class)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "firebase"
    }

    abstract fun taskListDao(): TaskListDao
}