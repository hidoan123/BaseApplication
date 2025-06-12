package com.example.baseapplication

import android.os.Bundle
import com.example.baseapplication.common.activity.BaseActivity
import com.example.baseapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun setupUI(savedInstanceState: Bundle?) {
        super.setupUI(savedInstanceState)

    }

}