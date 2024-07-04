package com.example.quranapp

import android.app.Application
import com.example.quranapp.data.local.MyDatabase

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        MyDatabase.getInstance(this)
    }
}