package com.feelingm.firebasetest.di

import android.arch.persistence.room.Room
import android.content.Context
import com.feelingm.firebasetest.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018. 2. 23..
 */

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME)

    @Provides
    @Singleton
    fun provideTaskListDao(database: AppDatabase) = database.taskListDao()
}