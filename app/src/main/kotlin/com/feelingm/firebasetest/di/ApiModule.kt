package com.feelingm.firebasetest.di

import com.feelingm.firebasetest.api.TaskListApi
import com.google.api.services.tasks.Tasks
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018. 2. 23..
 */

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideTasks(tasks: Tasks) = TaskListApi(tasks)

}