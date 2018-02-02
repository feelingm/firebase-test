package com.feelingm.firebasetest.ui.auth

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.feelingm.firebasetest.R
import com.feelingm.firebasetest.util.databinding.BaseObservableViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * Created by mac on 2018. 1. 23..
 */

class GoogleSignInViewModel(val firebaseAuth: FirebaseAuth,
                            val googleSignInClient: GoogleSignInClient,
                            application: Application)
    : BaseObservableViewModel(application) {

    val RC_SIGN_IN = 1000

    val statusText = MutableLiveData<String>()
    val detailText = MutableLiveData<String>()

    val signedIn = MutableLiveData<Boolean>()

    fun updateUser(user: FirebaseUser?) {
        if (user != null) {
            statusText.postValue(app.getString(R.string.google_status_fmt, user.email))
            detailText.postValue(app.getString(R.string.firebase_status_fmt, user.uid))

            signedIn.postValue(true)
        } else {
            statusText.postValue(app.getString(R.string.signed_out))
            detailText.postValue(null)

            signedIn.postValue(false)
        }
    }

    fun signIn() =
            startActivityForResult(googleSignInClient.signInIntent, RC_SIGN_IN)

    fun signOut() {
        firebaseAuth.signOut()
        googleSignInClient.signOut().addOnCompleteListener {
            updateUser(null)
        }
    }

    fun revokeAccess() {
        firebaseAuth.signOut()

        googleSignInClient.revokeAccess().addOnCompleteListener {
            updateUser(null)
        }
    }

    fun onSignInButtonClicked(view: View) = signIn()

    fun onSignOutButtonClicked(view: View) = signOut()

    fun onDisconnectButtonClicked(view: View) = revokeAccess()
}