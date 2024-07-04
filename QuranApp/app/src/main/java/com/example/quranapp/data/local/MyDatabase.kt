package com.example.quranapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quranapp.data.models.Ayah
import com.example.quranapp.data.models.Data
import com.example.quranapp.data.models.SurahDetailsModel

import com.example.quranapp.data.models.SurahModel

@Database(entities = [Data::class,SurahDetailsModel::class], version = 8)
@TypeConverters(value = [Converter::class])
abstract class MyDatabase :RoomDatabase(){


     abstract fun getMyDao():MyDao

     companion object{
         var myDatabase:MyDatabase?=null

         fun getInstance(context: Context){
             myDatabase = Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"quran_app_db")
                 .fallbackToDestructiveMigration()
                 .build()

         }
     }

}