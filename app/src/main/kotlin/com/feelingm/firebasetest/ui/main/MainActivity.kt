package com.feelingm.firebasetest.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import com.feelingm.firebasetest.R
import com.feelingm.firebasetest.ui.auth.GoogleSignInFragment
import com.feelingm.firebasetest.util.component.BaseActivity
import com.feelingm.firebasetest.util.navigation.NavigationManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NavigationManager.NavigationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationManager.init(supportFragmentManager)
        navigationManager.navigationListener = this

        navigationManager.openAsRoot(GoogleSignInFragment.newInstance())

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 1) {
//            showExitDialog();
        } else {
            navigationManager.navigateBack(this)
        }
    }

    override fun onBackstackChanged() {
//        drawerManager.enableDrawer(navigationManager.isRootFragmentVisible)
//        drawerManager.enableActionBarDrawerToggle(navigationManager.isRootFragmentVisible)
    }
}
