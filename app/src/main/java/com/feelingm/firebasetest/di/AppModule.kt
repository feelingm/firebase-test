package com.feelingm.firebasetest.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by mac on 2018. 1. 23..
 */

@Module
class AppModule {

    @Provides
    @Named("appContext")
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

}