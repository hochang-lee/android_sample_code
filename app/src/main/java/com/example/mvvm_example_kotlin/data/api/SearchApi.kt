package com.example.mvvm_example_kotlin.data.api

import com.example.mvvm_example_kotlin.data.api.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi{
    @GET("web")
    suspend fun getSearch(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : Response<SearchResponse>
}