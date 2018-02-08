package com.feelingm.firebasetest.di.ui

import android.app.Application
import com.feelingm.firebasetest.ui.auth.GoogleSignInViewModelFactory
import com.feelingm.firebasetest.ui.task.GoogleTaskViewModelFactory
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018. 1. 25..
 */

@Module
class GoogleTaskModule {

    @Provides
    fun provideGoogleTaskViewModelFactory(firebaseAuth: FirebaseAuth,
                                          googleSignInClient: GoogleSignInClient,
                                          application: Application) =
            GoogleTaskViewModelFactory(firebaseAuth, googleSignInClient, application)
}