package com.feelingm.firebasetest.ui.auth

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidhuman.example.simplegithub.rx.AutoClearedDisposable
import com.feelingm.firebasetest.R
import com.feelingm.firebasetest.util.base.BaseFragment
import javax.inject.Inject

class GoogleSignInFragment : BaseFragment() {

    companion object {
        fun newInstance() = GoogleSignInFragment()
    }

    @Inject lateinit var viewModelFactory: GoogleSignInViewModelFactory

    lateinit var viewModel: GoogleSignInViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_google_sign_in, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[GoogleSignInViewModel::class.java]



    }
}