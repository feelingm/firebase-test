package com.feelingm.firebasetest.ui.common.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.afollestad.materialdialogs.MaterialDialog
import com.feelingm.firebasetest.R

/**
 * Created by mac on 2018. 2. 3..
 */

class ProgressDialogFragment : DialogFragment() {


    companion object {

        const val EXTRA_INDETERMINATE = "Indeterminate"
        const val EXTRA_MAX = "Max"
        const val EXTRA_SHOW_MIN_MAX = "ShowMinMax"

        fun newInstance(indeterminate: Boolean = true,
                        max: Int = 100,
                        showMinMax: Boolean = false) =

                ProgressDialogFragment().apply {
                    val bundle = Bundle()
                    bundle.putBoolean(EXTRA_INDETERMINATE, indeterminate)
                    bundle.putInt(EXTRA_MAX, max)
                    bundle.putBoolean(EXTRA_SHOW_MIN_MAX, showMinMax)
                    arguments = bundle
                }
    }

    var indeterminate = false
    var max = 0
    var showMinMax = false

    private lateinit var dialog: MaterialDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.run {
            indeterminate = getBoolean(EXTRA_INDETERMINATE)
            max = getInt(EXTRA_MAX)
            showMinMax = getBoolean(EXTRA_SHOW_MIN_MAX)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        dialog = MaterialDialog.Builder(context!!)
                .title(R.string.progress_dialog_title)
                .content(R.string.progress_dialog_content)
                .progress(indeterminate, max, showMinMax)
                .show()

        return super.onCreateDialog(savedInstanceState)
    }


    val currentProgress
        get() = dialog.currentProgress

    val maxProgress
        get() = dialog.maxProgress

    fun incrementProgress(by: Int) {
        dialog.incrementProgress(by)
    }

}