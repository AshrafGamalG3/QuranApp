package com.example.quranapp.ui.showsurah

import android.util.Log
import com.example.quranapp.data.local.MyDatabase
import com.example.quranapp.data.models.Data
import com.example.quranapp.data.models.SurahModel
import com.example.quranapp.data.remote.surah.RetroConnection

class Repo {


    suspend fun getSurah():List<Data>{
        return try {
            val data = getSurahRemote()
            cacheSurah(data.data)
            data.data
        } catch (e: Exception) {
            getSurahLocal() ?: emptyList()

        }

    }

  private  suspend fun getSurahRemote():SurahModel {
     return   try {
            val data= RetroConnection.getApiCalls.getSurah()
         Log.e("TAG", "getSurahRemote:  api success ", )
                data
        }catch (e:Exception){
         Log.e("TAG", "getSurahRemote:  api fail + {${e.message}}", )
            throw  e
        }
    }

   private  fun getSurahLocal(): List<Data>? {
       Log.e("TAG", "getSurahLocal: get ", )
return MyDatabase.myDatabase?.getMyDao()?.getSurah()
    }
  private fun cacheSurah(list: List<Data>){
      Log.e("TAG", "getSurahLocal: inserted ", )
    MyDatabase.myDatabase?.getMyDao()?.insertSurah(list)
  }


}