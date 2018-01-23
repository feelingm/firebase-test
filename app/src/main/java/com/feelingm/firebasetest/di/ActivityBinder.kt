package com.feelingm.firebasetest.di

import com.feelingm.firebasetest.ui.auth.GoogleSignInFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mac on 2018. 1. 23..
 */

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [])
    abstract fun bindGoogleSignInFragment(): GoogleSignInFragment
}