package com.example.quranapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.quranapp.R
import com.example.quranapp.ui.showsurah.SurahActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this, SurahActivity::class.java ))
        },3000)
    }
}