package com.example.quranapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.quranapp.data.models.Data

import com.example.quranapp.data.models.SurahDetailsModel

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurah(list: List<Data>)

    @Query("SELECT * FROM Data")
    fun getSurah(): List<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurahDetails(apApiResponse: SurahDetailsModel)

    @Query("SELECT * FROM SurahDetailsModel WHERE number = :id")
    fun getSurahDetails(id: Int): SurahDetailsModel
}