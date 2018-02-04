package com.feelingm.firebasetest.util.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import com.feelingm.firebasetest.ui.common.BaseActivity
import com.feelingm.firebasetest.ui.common.BaseFragment
import com.feelingm.firebasetest.util.databinding.BaseObservableViewModel
import com.feelingm.firebasetest.util.databinding.ViewInteractionListener

class ViewInteractionLifecycle(
        private val baseFragment: BaseFragment,
        private val viewModel: BaseObservableViewModel)
    : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        viewModel.viewInteractionListener = object : ViewInteractionListener {
            override fun startActivity(intent: Intent, options: Bundle?) =
                baseFragment.startActivity(intent, options)

            override fun startActivityForResult(intent: Intent, requestCode: Int, options: Bundle?) =
                baseFragment.startActivityForResult(intent, requestCode, options)

            override fun replaceFragment(fragment: Fragment, openAsRoot: Boolean) =
                with ((baseFragment.activity as BaseActivity).navigationManager) {
                    if (openAsRoot) openAsRoot(fragment)
                    else open(fragment)
                }

            override fun showDialogFragment(fragment: DialogFragment) =
                (baseFragment.activity as BaseActivity).navigationManager.show(fragment)

            override fun showSnackbar(text: String, duration: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        viewModel.viewInteractionListener = null
        baseFragment.lifecycle.removeObserver(this)
    }

}
