package ua.ck.zabochen.darkmodeapp

import android.content.Context

class Preferences(context: Context) {

    private val preferences = context.getSharedPreferences(
        "appPreferences",
        Context.MODE_PRIVATE
    )

    private val keyIsDarkModeOn = "DARK_MODE_ON"
    var isDarkModeOn: Boolean = preferences.getBoolean(keyIsDarkModeOn, false)
        set(value) = preferences.edit().putBoolean(keyIsDarkModeOn, value).apply()
}