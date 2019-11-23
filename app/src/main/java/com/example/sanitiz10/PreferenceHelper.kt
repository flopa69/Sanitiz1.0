package com.example.sanitiz10
import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(private val context: Context) {
    private val INTRO = "intro"
    private val NAME = "name"
    private val app_prefs: SharedPreferences

    init {
        app_prefs = context.getSharedPreferences(
            "shared",
            Context.MODE_PRIVATE
        )
    }

    fun putIsLogin(login: Boolean) {
        val edit = app_prefs.edit()
        edit.putBoolean(INTRO, login)
        edit.commit()
    }

    fun getIsLogin(): Boolean {
        return app_prefs.getBoolean(INTRO, false)
    }

    fun putName(login: String) {
        val edit = app_prefs.edit()
        edit.putString(NAME, login)
        edit.commit()
    }

    fun getNames(): String? {
        return app_prefs.getString(NAME, "")
    }
}
