package com.feelingm.firebasetest.util.base

import android.os.Bundle
import android.view.View
import com.androidhuman.example.simplegithub.extensions.plusAssign
import com.androidhuman.example.simplegithub.rx.AutoClearedDisposable
import com.feelingm.firebasetest.R
import dagger.android.support.DaggerFragment

/**
 * Created by mac on 2018. 1. 25..
 */

open class BaseFragment : DaggerFragment() {

    protected val disposables by lazy {
        AutoClearedDisposable(activity as BaseActivity)
    }

    protected val viewDisposables by lazy {
        AutoClearedDisposable(activity as BaseActivity, alwaysClearOnStop = false)
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

}