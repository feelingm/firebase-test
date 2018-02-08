package com.feelingm.firebasetest.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feelingm.firebasetest.databinding.FragmentGoogleSignInBinding
import com.feelingm.firebasetest.databinding.FragmentGoogleTaskBinding
import com.feelingm.firebasetest.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_google_sign_in.*
import javax.inject.Inject

class GoogleTaskFragment : BaseFragment() {

    companion object {
        fun newInstance() = GoogleTaskFragment()
    }

    @Inject lateinit var viewModelFactory: GoogleTaskViewModelFactory

    private lateinit var viewModel: GoogleTaskViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = getViewModel(viewModelFactory, GoogleTaskViewModel::class.java)

        return FragmentGoogleTaskBinding.inflate(inflater, container, false).apply {
            viewModel = this@GoogleTaskFragment.viewModel
            setLifecycleOwner(this@GoogleTaskFragment)
        }.root
    }
}