package com.feelingm.firebasetest.util.navigation

import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.feelingm.firebasetest.R

/**
 * Created by mac on 2018. 1. 24..
 */

class NavigationManager {
    interface NavigationListener {

        fun onBackstackChanged()
    }


    private lateinit var fragmentManager: FragmentManager

    var navigationListener: NavigationListener? = null

    fun init(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager

        fragmentManager.addOnBackStackChangedListener {
            navigationListener?.onBackstackChanged()
        }
    }

    fun open(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragment.toString())
                .commit()
    }

    fun popAll() {
        fragmentManager.run {
            for (i in 0 until backStackEntryCount) {
                popBackStack(getBackStackEntryAt(i).id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }

    fun openAsRoot(fragment: Fragment) {
        popAll()
        open(fragment)
    }

    fun show(dialogFragment: DialogFragment) =
        dialogFragment.show(fragmentManager, dialogFragment.tag)

    fun navigateBack(activity: AppCompatActivity) {
        fragmentManager.run {
            if (backStackEntryCount == 0) {
                activity.finish()
            } else {
                popBackStackImmediate()
            }
        }
    }

    fun isRootFragmentVisible() = fragmentManager.backStackEntryCount <= 1



}