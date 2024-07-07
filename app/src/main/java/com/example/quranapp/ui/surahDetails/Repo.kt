package com.example.quranapp.ui.surahDetails

import android.util.Log
import com.example.quranapp.data.local.MyDao
import com.example.quranapp.data.local.MyDatabase
import com.example.quranapp.data.models.ApiResponse
import com.example.quranapp.data.models.Ayah
import com.example.quranapp.data.models.SurahDetailsModel
import com.example.quranapp.data.remote.surah.ApiCalls


import javax.inject.Inject

class Repo @Inject constructor(val getApiCalls: ApiCalls,val getMyDao:MyDao) {
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
        return getApiCalls.getSurahDetails(id)
    }

    private fun cacheSurah(dataDetails: SurahDetailsModel) {
        try {
            Log.e("TAG", "cacheSurah Details : ", )
          getMyDao.insertSurahDetails(dataDetails)
        } catch (e: Exception) {
            Log.e("Repo", "Failed to cache surah: ${e.message}")
        }
    }

    private fun getSurahLocal(id: Int): SurahDetailsModel? {
        return getMyDao.getSurahDetails(id)
    }
}
