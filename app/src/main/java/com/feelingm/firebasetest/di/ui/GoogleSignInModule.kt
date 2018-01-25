package com.feelingm.firebasetest.di.ui

import android.app.Application
import com.feelingm.firebasetest.ui.auth.GoogleSignInViewModelFactory
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides

/**
 * Created by mac on 2018. 1. 25..
 */

@Module
class GoogleSignInModule {

    @Provides
    fun provideGoogleSignViewModelFactory(firebaseAuth: FirebaseAuth,
                                          googleSignInClient: GoogleSignInClient,
                                          application: Application) =
            GoogleSignInViewModelFactory(firebaseAuth, googleSignInClient, application)
}