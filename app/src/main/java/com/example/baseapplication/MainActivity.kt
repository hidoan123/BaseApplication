package com.example.baseapplication

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.baseapplication.common.activity.BaseActivity
import com.example.baseapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var navController : NavController ?= null
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun setupUI(savedInstanceState: Bundle?) {
        super.setupUI(savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        navController = navHostFragment?.navController
    }

}