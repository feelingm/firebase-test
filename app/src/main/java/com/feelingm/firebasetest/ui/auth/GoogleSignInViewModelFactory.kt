package com.feelingm.firebasetest.ui.auth

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by mac on 2018. 1. 23..
 */

class GoogleSignInViewModelFactory(val application: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return GoogleSignInViewModel(application) as T
    }
}