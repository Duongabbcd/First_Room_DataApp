package gst.trainingcourse.studen_school_management.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse.studen_school_management.R
import gst.trainingcourse.studen_school_management.base.BaseFragment
import gst.trainingcourse.studen_school_management.databinding.FragmentLoginBinding
import gst.trainingcourse.studen_school_management.view.viewmodel.LoginViewModel

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
        private val loginViewModel :LoginViewModel by activityViewModels()
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater,container,false)

    override fun initAction() {
        binding.btnLogin.setOnClickListener {
            navigateToListNoteScreen()
        }
    }

    private fun navigateToListNoteScreen() {
       val  action =LoginFragmentDirections.fromLoginFramgentToListNoteFragment()
        findNavController().navigate(action)
    }
}