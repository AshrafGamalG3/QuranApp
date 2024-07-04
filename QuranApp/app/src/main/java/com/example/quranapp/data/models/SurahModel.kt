package com.example.quranapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class SurahModel(
    val code: Int,
    val `data`: List<Data>,
    val status: String
)
@Entity
data class Data(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    @PrimaryKey
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)