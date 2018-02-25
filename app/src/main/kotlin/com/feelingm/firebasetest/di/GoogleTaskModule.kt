package com.feelingm.firebasetest.di

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.http.HttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.services.tasks.Tasks
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mac on 2018. 2. 23..
 */

@Module
class GoogleTaskModule {

    @Provides
    @Singleton
    fun provideTasks(transport: HttpTransport, jsonFactory: JsonFactory,
                     credential: GoogleAccountCredential): Tasks =
            Tasks.Builder(transport, jsonFactory, credential).apply {
                applicationName = "Firebase"
            }.build()
}