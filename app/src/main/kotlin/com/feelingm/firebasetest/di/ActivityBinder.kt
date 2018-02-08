package com.feelingm.firebasetest.di

import com.feelingm.firebasetest.ui.main.MainActivity
import com.feelingm.firebasetest.ui.main.MainFragment
import com.feelingm.firebasetest.di.ui.GoogleSignInModule
import com.feelingm.firebasetest.di.ui.GoogleTaskModule
import com.feelingm.firebasetest.ui.auth.GoogleSignInFragment
import com.feelingm.firebasetest.ui.common.BaseActivity
import com.feelingm.firebasetest.ui.common.BaseFragment
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

    @ContributesAndroidInjector(modules = [ GoogleSignInModule::class, GoogleTaskModule::class ])
    abstract fun bindGoogleSignInFragment(): GoogleSignInFragment
}