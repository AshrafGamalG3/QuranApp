package com.example.quranapp.ui.showsurah

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.quranapp.data.local.MyDao
import com.example.quranapp.data.local.MyDatabase
import com.example.quranapp.data.models.Data
import com.example.quranapp.data.models.SurahModel
import com.example.quranapp.data.remote.surah.ApiCalls

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.math.log

class Repo  @Inject constructor(val getApiCalls: ApiCalls, val getMyDao: MyDao) {



    suspend fun getSurah(): List<Data> {
        Log.e("TAG", "getSurah: called")
        return try {
            val x =   showCurrentHour()

            Log.e("TAG", "getSurah: $x " , )

            val data = getSurahRemote()

            if (x.equals("10")){
                cacheSurah(data.data)
            }
            data.data
        } catch (e: Exception) {
            Log.e("TAG", "Failed to fetch surah: ${e.message}")
            getSurahLocal() ?: emptyList()
        }
    }

    private suspend fun getSurahRemote(): SurahModel {
        return getApiCalls.getSurah()
    }

    private fun cacheSurah(data: List<Data>) {
        try {
            getMyDao.insertSurah(data)
        } catch (e: Exception) {
            Log.e("TAG", "Failed to cache surah: ${e.message}")
        }
    }

    private fun getSurahLocal(): List<Data>? {
        Log.e("TAG", "Fetching from local cache")
        return getMyDao.getSurah()
    }

    fun showCurrentHour(): String {
        val currentTime = Date()
        val sdf = SimpleDateFormat("HH", Locale.getDefault())
        val formattedHour = sdf.format(currentTime)
      return formattedHour
    }

//    private suspend fun getSurahRemoteAnother(): List<Data> {
//        return runBlocking {
//            val flow1 = flow {
//                emit(RetroConnection.getApiCalls.getSurah())
//            }
//            val flow2 = flow {
//                emit(RetroConnection.getApiCalls.getSurah())
//            }
//
//            val combinedResult = flow1.zip(flow2) { a, b ->
//
//                Log.e("TAG", "getSurahRemoteAnother: ${a.data.size+b.data.size} ", )
//                a.data + b.data
//            }.firstOrNull() // Collect the first combined result
//
//            combinedResult ?: throw Exception("No result collected from flows")
//        }
//    }

}