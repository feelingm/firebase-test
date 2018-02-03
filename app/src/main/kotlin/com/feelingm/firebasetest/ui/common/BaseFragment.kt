package com.feelingm.firebasetest.ui.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.feelingm.firebasetest.R
import com.feelingm.firebasetest.util.databinding.BaseObservableViewModel
import com.feelingm.firebasetest.util.extensions.plusAssign
import com.feelingm.firebasetest.util.lifecycle.AutoClearedDisposable
import com.feelingm.firebasetest.util.lifecycle.ViewInteractionLifecycle
import dagger.android.support.DaggerFragment

/**
 * Created by mac on 2018. 1. 25..
 */

abstract class BaseFragment : DaggerFragment() {

    lateinit var baseViewModel: BaseObservableViewModel

    protected val disposables by lazy {
        AutoClearedDisposable(activity as BaseActivity)
    }

    protected val viewDisposables by lazy {
        AutoClearedDisposable(activity as BaseActivity, alwaysClearOnStop = false)
    }

    protected fun <T: ViewModel> getViewModel(
            factory: ViewModelProvider.Factory, modelClass: Class<T>): T {

        baseViewModel = (ViewModelProviders.of(this, factory)
                [modelClass] as BaseObservableViewModel).apply {
            disposables = this@BaseFragment.disposables
        }

        lifecycle += ViewInteractionLifecycle(this, baseViewModel)

        @Suppress("UNCHECKED_CAST")
        return baseViewModel as T
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle += disposables
        lifecycle += viewDisposables
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initActionBar(true, getString(R.string.app_name))
    }

    protected fun initActionBar(showHomeButton: Boolean, title2: String) {

        check(activity is BaseActivity?)

        (activity as BaseActivity).supportActionBar?.run {
            setHomeButtonEnabled(showHomeButton)
            title = title2
        }
    }

    protected fun showActionBar(isShown: Boolean) {
        check(activity is BaseActivity?)


        (activity as BaseActivity).supportActionBar?.run {
            if (isShown) show()
            else hide()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        baseViewModel.onActivityResult(requestCode, resultCode, data)
    }
}