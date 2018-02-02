package com.feelingm.firebasetest.util.databinding

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import com.feelingm.firebasetest.util.lifecycle.AutoClearedDisposable

/**
 * Created by mac on 2018. 2. 2..
 */

abstract class BaseObservableViewModel(app: Application)
    : ObservableViewModel(app), ViewModelListener {


    var viewInteractionListener: ViewInteractionListener? = null

    lateinit var disposables: AutoClearedDisposable

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    fun startActivity(intent: Intent, options: Bundle? = null) =
        viewInteractionListener?.requestStartActivity(intent, options)
                ?: IllegalStateException("ViewInteractionListener is null")

    fun startActivityForResult(intent: Intent, requestCode: Int, options: Bundle? = null) =
        viewInteractionListener?.requestStartActivityForResult(intent, requestCode, options)
                ?: IllegalStateException("ViewInteractionListener is null")


    fun replaceFragment(fragment: Fragment, openAsRoot: Boolean) =
        viewInteractionListener?.requestReplaceFragment(fragment, openAsRoot)
                ?: IllegalStateException("ViewInteractionListener is null")

    fun showDialogFragment(fragment: DialogFragment) =
        viewInteractionListener?.requestShowDialogFragment(fragment)
                ?: IllegalStateException("ViewInteractionListener is null")
}