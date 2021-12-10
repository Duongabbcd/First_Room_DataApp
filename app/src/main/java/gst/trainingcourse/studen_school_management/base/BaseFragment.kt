package gst.trainingcourse.studen_school_management.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.IllegalArgumentException

abstract  class BaseFragment <out T :ViewBinding> : Fragment() {
        private var _binding:T ? = null

    protected  val binding
    get() = _binding?: throw IllegalArgumentException(
        "binding is only valid between onCreateView and onDestroyView"
    )

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = createBinding(inflater, container, savedInstanceState)
        return binding.root
    }

    abstract fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):T


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerLiveData()
        initData()
        initView()
        initAction()
    }

    open fun initAction(){

    }


    open fun initData(){

    }

    open fun initView(){

    }

    open fun observerLiveData(){

    }

    @CallSuper
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}