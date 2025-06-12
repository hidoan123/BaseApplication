package com.example.baseapplication.common.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    private var _binding: DB? = null
    protected val binding: DB get() = _binding!!

    @get:LayoutRes
    protected abstract val layoutId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        //setupLanguage()
    }

    protected open fun setupUI(savedInstanceState : Bundle?) {}
    protected open fun setupData() {}
    protected open fun setupListener() {}

    protected open fun initBinding() {
        _binding = createBinding()
    }

    private fun createBinding(): DB? {
        return DataBindingUtil.setContentView(this, layoutId)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding?.unbind()
        _binding = null
    }
//    private fun setupLanguage() {
//        val preferences = BasePrefers.initPrefs(this)
//        val locale = Locale.forLanguageTag(preferences.locale ?: Constants.en)
//        val config = resources.configuration
//        Locale.setDefault(locale)
//        config.setLocale(locale)
//        createConfigurationContext(config)
//        resources.updateConfiguration(config, resources.displayMetrics)
//    }

}