package com.feelingm.firebasetest.util.databinding

import android.content.Intent

/**
 * Created by mac on 2018. 2. 2..
 */

interface ViewModelListener {

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}