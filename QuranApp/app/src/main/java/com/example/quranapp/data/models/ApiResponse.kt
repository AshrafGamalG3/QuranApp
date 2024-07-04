package com.example.quranapp.data.models

data class ApiResponse(
    val code: Int,
    val status: String,
    val data: SurahDetailsModel
)