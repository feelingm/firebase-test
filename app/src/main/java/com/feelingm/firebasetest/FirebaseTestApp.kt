package com.feelingm.firebasetest

import com.feelingm.firebasetest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by mac on 2018. 1. 23..
 */
class FirebaseTestApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}