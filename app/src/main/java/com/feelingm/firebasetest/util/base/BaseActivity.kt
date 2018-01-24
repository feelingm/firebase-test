package com.feelingm.firebasetest.util.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.feelingm.firebasetest.util.navigation.NavigationManager
import javax.inject.Inject

/**
 * Created by mac on 2018. 1. 24..
 */

abstract class BaseActivity : AppCompatActivity() {


    internal lateinit var contentLayout: FrameLayout

    @Inject
    internal lateinit var navigationManager: NavigationManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}