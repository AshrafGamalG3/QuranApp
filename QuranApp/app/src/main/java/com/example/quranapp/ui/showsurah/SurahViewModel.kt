package com.example.quranapp.ui.showsurah

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.data.models.Data
import com.example.quranapp.data.models.SurahModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SurahViewModel :ViewModel() {
     var mutableLiveData = MutableLiveData<List<Data>?>()



    private val repo=Repo()


    fun getSurah(){
        try {
            viewModelScope.launch(IO) {
                val data=repo.getSurah()
                withContext(Main){
                    mutableLiveData.value=data
                }

            }

        }catch (e:Exception){

        }
    }

}