package com.example.quranapp.ui.surahDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.quranapp.R
import com.example.quranapp.adapters.surah.SurahAdapter
import com.example.quranapp.adapters.surahdetails.SurahDetails
import com.example.quranapp.databinding.ActivitySurahBinding
import com.example.quranapp.databinding.ActivitySurahDetailsBinding
import com.example.quranapp.ui.showsurah.SurahViewModel

class SurahDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySurahDetailsBinding
    lateinit var model: SurahDetailsViewModel
    val adapterDetails= SurahDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySurahDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model=ViewModelProvider(this)[SurahDetailsViewModel::class]

        val surahId = intent.getIntExtra("SURAH_ID", -1)
        val numberOfAyahs = intent.getIntExtra("numberOfAyahs", 0)
        val name = intent.getStringExtra("name") ?: ""
        val englishName = intent.getStringExtra("englishName") ?: ""
        binding.surahName.text=name
        binding.translation.text=englishName
        binding.type.text= numberOfAyahs.toString()
        Log.e("TAG", "onCreate===================: + $surahId", )
        getSurahDetails(surahId)
        observer()

    }


    fun getSurahDetails(id:Int){
        model.getSurahDetails(id)
    }
    fun observer(){
        model.mutableLiveData.observe(this){
            adapterDetails.list= it!!
            binding.surahDetailRv.adapter=adapterDetails


        }
    }
}