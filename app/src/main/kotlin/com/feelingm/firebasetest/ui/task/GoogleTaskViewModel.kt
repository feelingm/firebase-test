package com.feelingm.firebasetest.ui.task

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.view.View
import com.feelingm.firebasetest.R
import com.feelingm.firebasetest.ui.common.dialog.ProgressDialogFragment
import com.feelingm.firebasetest.util.databinding.BaseObservableViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import org.jetbrains.anko.design.snackbar

/**
 * Created by mac on 2018. 1. 23..
 */

class GoogleTaskViewModel(val firebaseAuth: FirebaseAuth,
                          val googleSignInClient: GoogleSignInClient,
                          application: Application)
    : BaseObservableViewModel(application) {

    companion object {
        const val RC_SIGN_IN = 1000
    }

    val statusText = MutableLiveData<String>()
    val detailText = MutableLiveData<String>()

    val signedIn = MutableLiveData<Boolean>()

    private val progressBar = ProgressDialogFragment.newInstance(indeterminate = true)


}