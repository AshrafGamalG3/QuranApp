package com.example.quranapp.ui.surahDetails

import android.util.Log
import com.example.quranapp.data.local.MyDatabase
import com.example.quranapp.data.models.ApiResponse
import com.example.quranapp.data.models.Ayah
import com.example.quranapp.data.models.SurahDetailsModel

import com.example.quranapp.data.remote.surah.RetroConnection
class Repo {
    suspend fun getSurah(id: Int): List<Ayah>? {
        return try {
            val response = getSurahRemote(id)
            val dataDetails = response.data
            cacheSurah(dataDetails)
            dataDetails.ayahs
        } catch (e: Exception) {
            Log.e("Repo", "Failed to fetch surah: ${e.message}")
            getSurahLocal(id)?.ayahs
        }
    }

    private suspend fun getSurahRemote(id: Int): ApiResponse {
        return RetroConnection.getApiCalls.getSurahDetails(id)
    }

    private fun cacheSurah(dataDetails: SurahDetailsModel) {
        try {
            MyDatabase.myDatabase?.getMyDao()?.insertSurahDetails(dataDetails)
        } catch (e: Exception) {
            Log.e("Repo", "Failed to cache surah: ${e.message}")
        }
    }

    private fun getSurahLocal(id: Int): SurahDetailsModel? {
        return MyDatabase.myDatabase?.getMyDao()?.getSurahDetails(id)
    }
}
