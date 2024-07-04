package com.example.quranapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class SurahDetailsModel(
    val ayahs: List<Ayah>,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
 @PrimaryKey
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)

data class Ayah(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,

    val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Boolean,
    val text: String
)