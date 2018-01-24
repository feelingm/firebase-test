package com.feelingm.firebasetest.di

import com.feelingm.firebasetest.MainActivity
import com.feelingm.firebasetest.MainActivityFragment
import com.feelingm.firebasetest.ui.auth.GoogleSignInFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mac on 2018. 1. 23..
 */

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainActivityFragment

    @ContributesAndroidInjector
    abstract fun bindGoogleSignInFragment(): GoogleSignInFragment
}