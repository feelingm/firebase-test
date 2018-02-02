package com.feelingm.firebasetest.util.databinding

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment

/**
 * Created by mac on 2018. 2. 2..
 */

interface ViewInteractionListener {

    fun requestStartActivity(intent: Intent, options: Bundle? = null)
    fun requestStartActivityForResult(intent: Intent, requestCode: Int, options: Bundle? = null)
    fun requestReplaceFragment(fragment: Fragment, openAsRoot: Boolean = false)
    fun requestShowDialogFragment(fragment: DialogFragment)

}