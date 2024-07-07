package com.example.quranapp.ui.showsurah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.quranapp.R
import com.example.quranapp.adapters.surah.SurahAdapter
import com.example.quranapp.adapters.surah.onClickSurah
import com.example.quranapp.data.models.Data
import com.example.quranapp.databinding.ActivitySurahBinding
import com.example.quranapp.ui.surahDetails.SurahDetailsActivity
import com.example.quranapp.ui.surahDetails.SurahDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SurahActivity : AppCompatActivity() {
 lateinit var binding: ActivitySurahBinding
 lateinit var model: SurahViewModel
 val surahAdapter=SurahAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySurahBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model=ViewModelProvider(this)[SurahViewModel::class]

        getSurah()
        observer()
        onClick()
    }


    fun onClick(){
        surahAdapter.onClick = object : onClickSurah {
            override fun onClick(data: Data) {
                val intent = Intent(this@SurahActivity, SurahDetailsActivity::class.java)
                intent.putExtra("SURAH_ID", data.number)
                intent.putExtra("numberOfAyahs",data.numberOfAyahs)
                intent.putExtra("name",data.name)
                intent.putExtra("englishName",data.englishName)
                startActivity(intent)
            }

        }
    }

//    fun getSurah(){
//        model.getSurah()
//
//    }
//
//    fun observer(){
//        model.mutableLiveData.observe(this){
//            surahAdapter.list= it!!
//            binding.recyclerSurah.adapter=surahAdapter
//        }
//    }
    fun getSurah(){
        model.getSurahFlow()

    }

    fun observer(){
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                model.dataList.collect(){
                    surahAdapter.list= it
                    binding.recyclerSurah.adapter=surahAdapter
                }
            }
        }


    }


}