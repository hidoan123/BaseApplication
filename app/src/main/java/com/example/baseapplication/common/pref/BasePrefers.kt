package com.example.baseapplication.common.pref

import android.content.Context
import androidx.preference.PreferenceManager

class BasePrefers(private val context : Context) {
    private val mPrefs = PreferenceManager.getDefaultSharedPreferences(context)

    companion object {
        @Volatile
        private var INSTANCE: BasePrefers? = null
        fun initPrefs(context: Context): BasePrefers {
            return INSTANCE ?: synchronized(this) {
                val instance = BasePrefers(context)
                INSTANCE = instance
                instance
            }
        }

        fun getPrefsInstance(): BasePrefers {
            return INSTANCE ?: error("GoPreferences not initialized!")
        }
    }

    private fun getPrefName(name: String): String {
        return "pref$name"
    }
}