package com.example.mvvm_example_kotlin.data.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderOfKakaoSearch : Interceptor{
    private val apiKey = ""
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        val request = origin.newBuilder()
            .addHeader("Authorization", "KakaoAK 3d97114bdc8bca10b585a4d31e96cdc1")
            .build()
        return chain.proceed(request)
    }
}