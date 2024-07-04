package com.example.quranapp.data.remote.surah


import com.example.quranapp.data.models.BASE_API_SURAH
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroConnection {

   private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_API_SURAH)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val getApiCalls= retrofit.create(ApiCalls::class.java)



}