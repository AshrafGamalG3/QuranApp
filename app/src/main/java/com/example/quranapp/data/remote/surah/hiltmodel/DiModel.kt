package com.example.quranapp.data.remote.surah.hiltmodel

import android.content.Context
import androidx.room.Room
import com.example.quranapp.data.local.MyDao
import com.example.quranapp.data.local.MyDatabase
import com.example.quranapp.data.models.BASE_API_SURAH
import com.example.quranapp.data.remote.surah.ApiCalls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiModel {



    @Singleton
    @Provides
    fun getRetrofit() :Retrofit{
      return  Retrofit.Builder()
            .baseUrl(BASE_API_SURAH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Singleton
    @Provides
    fun getApiCalls(retrofit:Retrofit):ApiCalls{
     return   retrofit.create(ApiCalls::class.java)
    }

    @Singleton
    @Provides
    fun getMyDatabase(@ApplicationContext context:Context):MyDatabase{
       return  Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"quran_app_db")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun getMyDao(myDatabase: MyDatabase):MyDao{
        return myDatabase.getMyDao()
    }
}