package com.example.baseapplication.main.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.baseapplication.R
import com.example.baseapplication.common.fragment.BaseFragment
import com.example.baseapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {



    private val viewModel by viewModels<HomeViewModel>()


    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun setupUI() {
        super.setupUI()
        observerData()

    }

    override fun setupListener() {
        super.setupListener()

    }

    private fun observerData() {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.uiState.collect {
                when (it) {
                    is HomeUIState.Loading -> {
                    }
                    is HomeUIState.Success -> {
                    }
                    is HomeUIState.Error -> {
                    }
                }
            }
        }
    }
    }




}