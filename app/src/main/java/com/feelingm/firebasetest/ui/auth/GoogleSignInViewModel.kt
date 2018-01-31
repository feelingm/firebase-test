package com.feelingm.firebasetest.ui.auth

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.feelingm.firebasetest.util.databinding.BaseViewModelObservable
import com.feelingm.firebasetest.util.extensions.runOnIoScheduler
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by mac on 2018. 1. 23..
 */

class GoogleSignInViewModel(val firebaseAuth: FirebaseAuth,
                            val googleSignInClient: GoogleSignInClient,
                            application: Application)
    : BaseViewModelObservable(application) {

//    val

    fun signOut() = runOnIoScheduler {
        firebaseAuth.signOut()

        googleSignInClient.signOut().addOnCompleteListener {

        }
    }

    fun revokeAccess() = runOnIoScheduler {
        firebaseAuth.signOut()

        googleSignInClient.revokeAccess().addOnCompleteListener {

        }
    }


}