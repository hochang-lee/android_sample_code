package com.example.mvvm_example_kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_example_kotlin.model.SaveDataEntity
import com.example.mvvm_example_kotlin.remote.KakaoSearchResults
import com.example.mvvm_example_kotlin.repository.KaKaoRepository
import com.example.mvvm_example_kotlin.repository.SaveRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val kaKaoRepository: KaKaoRepository,
    private val saveRepository: SaveRepository
    ) : ViewModel() {
    var searchList : MutableLiveData<KakaoSearchResults> = MutableLiveData()
    var savedList : MutableLiveData<List<SaveDataEntity>> = MutableLiveData()


    fun getKakaoSearch(query : String, sort : String, page : Int, size : Int){
        CoroutineScope(Dispatchers.IO).launch{
            searchList.postValue(kaKaoRepository.getSearchData(query, sort, page, size).body())
        }
    }

    fun saveData(title : String, contents : String, url : String){
        CoroutineScope(Dispatchers.IO).launch {
            saveRepository.insert(title,contents,url)
        }
    }

    fun getSavedData(){
        CoroutineScope(Dispatchers.IO).launch {
            savedList.postValue(saveRepository.get())
        }
    }


}