package com.example.zoominfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ZoomApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}