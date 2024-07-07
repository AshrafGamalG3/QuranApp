package com.example.quranapp.ui.surahDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.data.models.Ayah
import com.example.quranapp.data.models.Data
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SurahDetailsViewModel @Inject constructor(val repo: Repo):ViewModel() {
    var mutableLiveData = MutableLiveData<List<Ayah>?>()




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