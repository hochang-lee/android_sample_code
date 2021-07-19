package com.example.mvvm_example_kotlin.repository

import com.example.mvvm_example_kotlin.remote.KakaoSearchResults
import com.example.mvvm_example_kotlin.remote.KakaoSearchService
import retrofit2.Response

class KakaoRepositoryImpl(private val service : KakaoSearchService) : KaKaoRepository{
    override suspend fun getSearchData(query: String, sort: String, page: Int, size: Int): Response<KakaoSearchResults> {
        return service.getSearch(query, sort, page, size)
    }
}