package com.example.zoominfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ZooApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}