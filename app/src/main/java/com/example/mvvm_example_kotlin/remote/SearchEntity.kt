package com.example.mvvm_example_kotlin.remote

import com.google.gson.annotations.SerializedName

data class KakaoSearchResults(
    @SerializedName("documents")
    val documents : List<Document>
){
    data class Document(
        @SerializedName("title")
        val title : String,
        @SerializedName("contents")
        val contents : String,
        @SerializedName("url")
        val url : String
    )
}
