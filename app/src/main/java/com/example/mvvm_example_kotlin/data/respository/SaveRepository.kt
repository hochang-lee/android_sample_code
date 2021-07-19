package com.example.mvvm_example_kotlin.data.respository

import com.example.mvvm_example_kotlin.data.db.entity.SaveDataEntity

interface SaveRepository {
    suspend fun get(): List<SaveDataEntity>
    suspend fun insert(title : String, contents : String, url : String): Long
}