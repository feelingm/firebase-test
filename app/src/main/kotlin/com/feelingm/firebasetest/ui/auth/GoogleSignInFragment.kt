package com.feelingm.firebasetest.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feelingm.firebasetest.databinding.FragmentGoogleSignInBinding
import com.feelingm.firebasetest.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_google_sign_in.*
import javax.inject.Inject

class GoogleSignInFragment : BaseFragment() {

    companion object {
        fun newInstance() = GoogleSignInFragment()
    }

    @Inject lateinit var viewModelFactory: GoogleSignInViewModelFactory

    private lateinit var viewModel: GoogleSignInViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = getViewModel(viewModelFactory, GoogleSignInViewModel::class.java)

        return FragmentGoogleSignInBinding.inflate(inflater, container, false).apply {
            viewModel = this@GoogleSignInFragment.viewModel
            setLifecycleOwner(this@GoogleSignInFragment)
        }.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sign_in_button.setOnClickListener {
            viewModel.signIn()
        }
    }
}