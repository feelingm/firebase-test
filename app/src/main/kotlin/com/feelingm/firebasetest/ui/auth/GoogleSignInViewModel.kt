package com.feelingm.firebasetest.ui.auth

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

class GoogleSignInViewModel(val firebaseAuth: FirebaseAuth,
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

    fun updateUser(user: FirebaseUser? = null) {
        progressBar.dismiss()

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
            updateUser()
        }
    }

    fun revokeAccess() {
        firebaseAuth.signOut()

        googleSignInClient.revokeAccess().addOnCompleteListener {
            updateUser()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != RC_SIGN_IN) {
            return
        }

        val task = GoogleSignIn.getSignedInAccountFromIntent(data)

        try {
            val account = task.getResult(ApiException::class.java)
            firebasethWithGoogle(account)
        } catch (e: ApiException) {
            // TODO: SnackBar
            updateUser()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun firebasethWithGoogle(account: GoogleSignInAccount) {

        showDialogFragment(progressBar)

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        updateUser(firebaseAuth.currentUser)
                    } else {
                        // Snackbar: auth failed
                        updateUser()
                    }

                    progressBar.dismiss()
                }

    }

//    fun onSignInButtonClicked(view: View) = signIn()

    fun onSignOutButtonClicked(view: View) = signOut()

    fun onDisconnectButtonClicked(view: View) = revokeAccess()
}