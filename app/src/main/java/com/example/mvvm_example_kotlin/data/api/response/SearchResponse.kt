package com.example.mvvm_example_kotlin.data.api.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(
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
