package com.feelingm.firebasetest.ui.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.feelingm.firebasetest.R
import com.feelingm.firebasetest.util.databinding.BaseObservableViewModel
import com.feelingm.firebasetest.util.databinding.ViewInteractionListener
import com.feelingm.firebasetest.util.extensions.plusAssign
import com.feelingm.firebasetest.util.lifecycle.AutoClearedDisposable
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by mac on 2018. 1. 25..
 */

abstract class BaseFragment : DaggerFragment(), ViewInteractionListener {

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

        }.apply {

                    disposables += requestActivity.subscribeOn(AndroidSchedulers.mainThread())
                            .subscribe { dto ->

                                if (dto.requestCode > 0) {
                                    if (!requestStartActivityForResult(dto.intent, dto.requestCode,
                                                    dto.options, dto.tag)) {
                                        this@BaseFragment.startActivityForResult(dto.intent, dto.requestCode, dto.options)
                                    }
                                } else {
                                    if (!requestStartActivity(dto.intent, dto.options, dto.tag)) {
                                        this@BaseFragment.startActivity(dto.intent, dto.options)
                                    }
                                }
                            }

                    disposables += requestFragment.subscribeOn(AndroidSchedulers.mainThread())
                            .subscribe { dto ->
                                if (!requestReplaceFragment(dto.fragment, dto.openAsRoot, dto.tag)) {

                                    with((activity as BaseActivity).navigationManager) {
                                        if (dto.openAsRoot) openAsRoot(dto.fragment)
                                        else open(dto.fragment)
                                    }
                                }
                            }

                    disposables += requestDialog.subscribeOn(AndroidSchedulers.mainThread())
                            .subscribe { dto ->
                                if (dto.show) {
                                    if (!requestShowDialog(dto.fragment, dto.tag)) {
                                        dto.fragment.show(this@BaseFragment.fragmentManager, dto.fragment.toString())
                                    }
                                } else {
                                    if (!requestHideDialog(dto.fragment, dto.tag)) {
                                        dto.fragment.dismiss()
                                    }
                                }
                            }

                    disposables += requestSnackbar.subscribeOn(AndroidSchedulers.mainThread())
                            .subscribe { dto ->
                                if (!requestShowSnackbar(dto.text, dto.showLong, dto.tag)) {
                                    Snackbar.make(view!!, dto.text,
                                            if (dto.showLong) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT).show()
                                }
                            }

                    disposables += requestToast.subscribeOn(AndroidSchedulers.mainThread())
                            .subscribe { dto ->
                                if (!requestShowToast(dto.text, dto.showLong, dto.tag)) {
                                    Toast.makeText(context, dto.text,
                                            if (dto.showLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
                                }
                            }

                    disposables += requestEvent.subscribeOn(AndroidSchedulers.mainThread())
                            .subscribe { dto ->
                                requestSendEvent(dto.tag, dto.intData)
                            }
                }

        @Suppress("UNCHECKED_CAST")
        return baseViewModel as T
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle += disposables
        lifecycle += viewDisposables
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

    override fun requestStartActivity(intent: Intent, options: Bundle?,
                                      tag: String?): Boolean = false

    override fun requestStartActivityForResult(intent: Intent, requestCode: Int,
                                               options: Bundle?, tag: String?): Boolean = false

    override fun requestReplaceFragment(fragment: Fragment, openAsRoot: Boolean,
                                        tag: String?): Boolean = false

    override fun requestShowDialog(fragment: DialogFragment, tag: String?): Boolean = false

    override fun requestHideDialog(fragment: DialogFragment, tag: String?): Boolean = false

    override fun requestShowSnackbar(text: String, showLong: Boolean, tag: String?): Boolean = false

    override fun requestShowToast(text: String, showLong: Boolean, tag: String?): Boolean = false

    override fun requestSendEvent(tag: String?, intData: Int?): Boolean = false
}