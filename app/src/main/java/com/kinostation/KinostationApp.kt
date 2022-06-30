package com.kinostation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KinostationApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}