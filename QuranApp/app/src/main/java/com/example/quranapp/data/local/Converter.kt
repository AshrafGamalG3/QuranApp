package com.example.quranapp.data.local

import androidx.room.TypeConverter
import com.example.quranapp.data.models.Ayah
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromAyahList(value: List<Ayah>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<Ayah>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAyahList(value: String?): List<Ayah>? {
        val gson = Gson()
        val type = object : TypeToken<List<Ayah>>() {}.type
        return gson.fromJson(value, type)
    }
}