package com.feelingm.firebasetest.ui.task

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by mac on 2018. 1. 23..
 */

class GoogleTaskViewModelFactory(private val firebaseAuth: FirebaseAuth,
                                 private val googleSignInClient: GoogleSignInClient,
                                 val application: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return GoogleTaskViewModel(firebaseAuth, googleSignInClient, application) as T
    }
}