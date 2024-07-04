package com.example.quranapp.ui.surahDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.data.models.Ayah
import com.example.quranapp.data.models.Data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SurahDetailsViewModel:ViewModel() {
    var mutableLiveData = MutableLiveData<List<Ayah>?>()

  private  val repo=Repo()


    fun getSurahDetails(id: Int){
      try {
          viewModelScope.launch(IO) {

              val data=repo.getSurah(id)
              withContext(Main){
                  mutableLiveData.value=data
              }

          }

      }
      catch (e:Exception){

      }
    }
}