package com.example.mvvm_example_kotlin.data.respository

import com.example.mvvm_example_kotlin.data.api.response.SearchResponse
import retrofit2.Response

interface SearchRepository{
    suspend fun getSearchData(query : String, sort : String, page : Int, size : Int) : Response<SearchResponse>
}