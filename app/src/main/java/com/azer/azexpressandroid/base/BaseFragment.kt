package com.azer.azexpressandroid.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseFragment<ViewBinding : ViewDataBinding> : Fragment() {
    lateinit var viewBinding: ViewBinding
    @get:LayoutRes
    abstract val layoutId: Int
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }

        initView()
        bindEvent()
        bindViewModel()
    }

    open fun bindViewModel() {}
    open fun bindEvent() {}
    open fun initView() {}

}