package com.feelingm.firebasetest.di

import com.feelingm.firebasetest.util.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018. 1. 24..
 */

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideNavigationManager() = NavigationManager()
}