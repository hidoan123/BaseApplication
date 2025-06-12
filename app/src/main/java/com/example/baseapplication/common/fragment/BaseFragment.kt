package com.example.baseapplication.common.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import timber.log.Timber

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    @get:LayoutRes
    protected abstract val layoutId: Int
    protected var binding: T? = null

    protected open fun setupUI() {}
    protected open fun setupData() {}
    protected open fun setupListener() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag("----onCreated:").d(this.javaClass.simpleName)
        setupData()
        setupUI()
        setupListener()
    }

    override fun onResume() {
        Timber.tag("----onResume:").d(this.javaClass.simpleName)
        super.onResume()

    }

    fun requireContext(action: (nonNullContext: Context) -> Unit) {
        context?.let(action)
    }

    fun toast(message: String, isLong: Boolean? = false) {
        context?.let {
            Toast.makeText(
                it,
                message,
                if (isLong == false) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
        binding = null
        Timber.tag("----onDestroy:").d(this.javaClass.simpleName)
    }

    fun withBinding(action: T.() -> Unit) {
        binding?.action()
    }
}