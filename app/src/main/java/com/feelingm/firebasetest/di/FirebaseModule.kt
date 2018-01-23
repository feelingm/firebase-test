package com.feelingm.firebasetest.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018. 1. 23..
 */

@Module
class FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    fun provideGoogleClient
}