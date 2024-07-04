package com.example.quranapp.data.remote.surah

import com.example.quranapp.data.models.ApiResponse
import com.example.quranapp.data.models.Ayah
import retrofit2.http.Query
import com.example.quranapp.data.models.Data

import com.example.quranapp.data.models.SurahDetailsModel

import com.example.quranapp.data.models.SurahModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCalls {


    @GET("surah")
    suspend fun getSurah(): SurahModel

    @GET("surah/{id}")
    suspend fun getSurahDetails(@Path("id") id: Int): ApiResponse


}