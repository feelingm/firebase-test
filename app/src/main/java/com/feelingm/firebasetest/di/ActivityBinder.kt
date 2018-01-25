package com.feelingm.firebasetest.di

import com.feelingm.firebasetest.MainActivity
import com.feelingm.firebasetest.MainFragment
import com.feelingm.firebasetest.di.ui.GoogleSignInModule
import com.feelingm.firebasetest.ui.auth.GoogleSignInFragment
import com.feelingm.firebasetest.util.base.BaseActivity
import com.feelingm.firebasetest.util.base.BaseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mac on 2018. 1. 23..
 */

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector
    abstract fun bindBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun bindBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

    @ContributesAndroidInjector(modules = [ GoogleSignInModule::class ])
    abstract fun bindGoogleSignInFragment(): GoogleSignInFragment
}