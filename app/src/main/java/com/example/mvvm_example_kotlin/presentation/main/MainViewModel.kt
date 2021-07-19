package com.example.mvvm_example_kotlin.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_example_kotlin.data.db.entity.SaveDataEntity
import com.example.mvvm_example_kotlin.data.api.response.SearchResponse
import com.example.mvvm_example_kotlin.data.respository.SearchRepository
import com.example.mvvm_example_kotlin.data.respository.SaveRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchRepository: SearchRepository,
    private val saveRepository: SaveRepository
    ) : ViewModel() {
    var searchList : MutableLiveData<SearchResponse> = MutableLiveData()
    var savedList : MutableLiveData<List<SaveDataEntity>> = MutableLiveData()


    fun getSearchData(query : String, sort : String, page : Int, size : Int){
        CoroutineScope(Dispatchers.IO).launch{
            searchList.postValue(searchRepository.getSearchData(query, sort, page, size).body())
        }
    }

    fun saveDataToDb(title : String, contents : String, url : String){
        CoroutineScope(Dispatchers.IO).launch {
            saveRepository.insert(title,contents,url)
        }
    }

    fun getSavedList(){
        CoroutineScope(Dispatchers.IO).launch {
            savedList.postValue(saveRepository.get())
        }
    }


}