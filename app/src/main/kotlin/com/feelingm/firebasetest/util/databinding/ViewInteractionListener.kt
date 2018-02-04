package com.feelingm.firebasetest.util.databinding

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment

/**
 * Created by mac on 2018. 2. 2..
 */

interface ViewInteractionListener {

    fun startActivity(intent: Intent, options: Bundle? = null)
    fun startActivityForResult(intent: Intent, requestCode: Int, options: Bundle? = null)
    fun replaceFragment(fragment: Fragment, openAsRoot: Boolean = false)
    fun showDialogFragment(fragment: DialogFragment)
    fun showSnackbar(text: String, duration: Int = Snackbar.LENGTH_LONG)
}