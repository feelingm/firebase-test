package com.feelingm.firebasetest.di

import android.app.Application
import com.feelingm.firebasetest.FirebaseTestApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by mac on 2018. 1. 23..
 */

@Singleton
@Component(
        modules = [
        ActivityBinder::class,
        AppModule::class,
        AndroidInjectionModule::class,
        NavigationModule::class
        ])
interface AppComponent : AndroidInjector<FirebaseTestApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent

    }
}