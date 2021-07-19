package com.example.mvvm_example_kotlin.data.respository

import com.example.mvvm_example_kotlin.data.api.response.SearchResponse
import com.example.mvvm_example_kotlin.data.api.SearchApi
import retrofit2.Response

class SearchRepositoryImpl(private val api : SearchApi) : SearchRepository {
    override suspend fun getSearchData(query: String, sort: String, page: Int, size: Int): Response<SearchResponse> {
        return api.getSearch(query, sort, page, size)
    }
}