package com.feelingm.firebasetest.util.databinding

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment

/**
 * Created by mac on 2018. 2. 2..
 */

data class ActivityDto(val intent: Intent,
                       val requestCode: Int = 0,
                       val options: Bundle? = null,
                       val tag: String? = null)

data class FragmentDto(val fragment: Fragment,
                       val openAsRoot: Boolean = false,
                       val tag: String? = null)

data class DialogDto(val fragment: DialogFragment,
                     val show: Boolean = true,
                     val tag: String? = null)

open class SnackbarDto(val text: String,
                       val showLong: Boolean = false,
                       val tag: String? = null)

open class ToastDto(val text: String,
                    val showLong: Boolean = false,
                    val tag: String? = null)

interface ViewInteractionListener {

    fun requestStartActivity(intent: Intent, options: Bundle? = null, tag: String? = null): Boolean

    fun requestStartActivityForResult(intent: Intent, requestCode: Int, options: Bundle? = null, tag: String? = null): Boolean

    fun requestReplaceFragment(fragment: Fragment, openAsRoot: Boolean = false, tag: String? = null): Boolean

    fun requestShowDialog(fragment: DialogFragment, tag: String? = null): Boolean

    fun requestHideDialog(fragment: DialogFragment, tag: String? = null): Boolean

    fun requestShowSnackbar(text: String, showLong: Boolean = false, tag: String? = null): Boolean

    fun requestShowToast(text: String, showLong: Boolean = false, tag: String? = null): Boolean
}
