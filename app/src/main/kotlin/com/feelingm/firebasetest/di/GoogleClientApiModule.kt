package com.feelingm.firebasetest.di

import android.content.Context
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.client.util.ExponentialBackOff
import com.google.api.services.tasks.TasksScopes
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018. 2. 23..
 */

@Module
class GoogleClientApiModule {

    companion object {
        val SCOPES = arrayListOf(TasksScopes.TASKS)
    }

    @Provides
    @Singleton
    fun provideHttpTransport(): HttpTransport = AndroidHttp.newCompatibleTransport()

    @Provides
    @Singleton
    fun provideJsonfactory(): JsonFactory = JacksonFactory.getDefaultInstance()

    @Provides
    @Singleton
    fun provideGoogleAccountCredential(context: Context): GoogleAccountCredential =
            GoogleAccountCredential.usingOAuth2(context.applicationContext, SCOPES).apply {
                backOff = ExponentialBackOff()
            }
}