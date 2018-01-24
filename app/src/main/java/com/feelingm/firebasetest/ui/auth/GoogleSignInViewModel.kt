package com.feelingm.firebasetest.ui.auth

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by mac on 2018. 1. 23..
 */

class GoogleSignInViewModel(val firebaseAuth: FirebaseAuth,
                            val googleSignInClient: GoogleSignInClient,
                            application: Application)
    : AndroidViewModel(application) {

}