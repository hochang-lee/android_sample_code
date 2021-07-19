package com.example.mvvm_example_kotlin.repository

import com.example.mvvm_example_kotlin.remote.KakaoSearchResults
import retrofit2.Response

interface KaKaoRepository{
    suspend fun getSearchData(query : String, sort : String, page : Int, size : Int) : Response<KakaoSearchResults>
}