package com.example.mvvm_example_kotlin.repository

import com.example.mvvm_example_kotlin.model.SaveDataEntity

interface SaveRepository {
    suspend fun get(): List<SaveDataEntity>
    suspend fun insert(title : String, contents : String, url : String): Long
}