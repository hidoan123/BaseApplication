package com.example.baseapplication.common

import android.app.Application
import android.content.Intent
import android.os.Process
import com.example.baseapplication.MainActivity
import com.example.baseapplication.common.pref.BasePrefers
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import kotlin.system.exitProcess

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        handleException()
        BasePrefers.initPrefs(applicationContext)
    }

    private fun handleException() {
        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            FirebaseCrashlytics.getInstance().log("handleException : ${throwable.message}")
            FirebaseCrashlytics.getInstance().recordException(throwable)
            Timber.tag("MyApp").e(throwable, "Uncaught exception: %s", throwable.message)
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            Process.killProcess(Process.myPid())
            exitProcess(0)
        }
    }
}