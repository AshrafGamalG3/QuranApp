package com.example.quranapp

import android.app.Application
import com.example.quranapp.data.local.MyDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App :Application() {

    override fun onCreate() {
        super.onCreate()

    }
}