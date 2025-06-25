package com.example.baseapplication.main.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baseapplication.R
import com.example.baseapplication.common.fragment.BaseFragment
import com.example.baseapplication.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(){
    override val layoutId: Int
        get() = R.layout.fragment_splash



}