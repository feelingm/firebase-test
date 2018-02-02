package com.feelingm.firebasetest.util.component

import android.os.Bundle
import com.feelingm.firebasetest.util.navigation.NavigationManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by mac on 2018. 1. 24..
 */

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var navigationManager: NavigationManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        navigationManager.navigateBack(this)
    }

    protected fun setToolbarVisibility(visibility: Int) {
        toolbar.visibility = visibility
    }
}