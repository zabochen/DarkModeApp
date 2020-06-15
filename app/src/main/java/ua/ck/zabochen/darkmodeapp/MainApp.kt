package ua.ck.zabochen.darkmodeapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setNightMode()
    }

    private fun setNightMode() {
        when (Preferences(this).isDarkModeOn) {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}