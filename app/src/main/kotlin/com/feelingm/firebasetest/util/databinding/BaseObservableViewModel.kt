package com.feelingm.firebasetest.util.databinding

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import com.feelingm.firebasetest.util.lifecycle.AutoClearedDisposable
import io.reactivex.subjects.PublishSubject

/**
 * Created by mac on 2018. 2. 2..
 */

abstract class BaseObservableViewModel(app: Application)
    : ObservableViewModel(app), ViewModelListener {

    lateinit var disposables: AutoClearedDisposable

    val requestActivity = PublishSubject.create<ActivityDto>()

    val requestFragment = PublishSubject.create<FragmentDto>()

    val requestDialog = PublishSubject.create<DialogDto>()

    val requestSnackbar = PublishSubject.create<SnackbarDto>()

    val requestToast = PublishSubject.create<ToastDto>()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    fun startActivity(intent: Intent, options: Bundle? = null, tag: String? = null) {
        requestActivity.onNext(ActivityDto(intent,
                options = options,
                tag = tag))
    }


    fun startActivityForResult(intent: Intent, requestCode: Int,
                               options: Bundle? = null, tag: String? = null) {
        requestActivity.onNext(ActivityDto(intent,
                requestCode = requestCode,
                options = options,
                tag = tag))
    }

    fun replaceFragment(fragment: Fragment, openAsRoot: Boolean = false, tag: String? = null) {
        requestFragment.onNext(FragmentDto(fragment, openAsRoot, tag))
    }

    fun showDialog(fragment: DialogFragment, tag: String? = null) {
        requestDialog.onNext(DialogDto(fragment, true, tag))
    }

    fun hideDialog(fragment: DialogFragment, tag: String? = null) {
        requestDialog.onNext(DialogDto(fragment, false, tag))
    }

    fun showSnackbar(text: String, showLong: Boolean = false, tag: String? = null) {
        requestSnackbar.onNext(SnackbarDto(text, showLong, tag))
    }

    fun showToast(text: String, showLong: Boolean = false, tag: String? = null) {
        requestToast.onNext(ToastDto(text, showLong, tag))
    }
}