package com.example.quranapp.ui.showsurah

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quranapp.data.models.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(val repo: Repo) :ViewModel() {
     var mutableLiveData = MutableLiveData<List<Data>?>()
    var dataList = MutableStateFlow<List<Data>>(emptyList())






    fun getSurah(){
        try {
            viewModelScope.launch(IO) {
                val data=repo.getSurah()
                withContext(Main){
                    mutableLiveData.value=data
                }

            }

        }catch (e:Exception){
        throw e
        }
    }
    fun getSurahFlow(){
        try {
            viewModelScope.launch(IO) {
                val data=repo.getSurah()
                withContext(Main){
                    dataList.emit(data)
                }

            }

        }catch (e:Exception){
        throw e
        }
    }

}