package com.example.mvvm_example_kotlin.repository

import com.example.mvvm_example_kotlin.model.SaveDao
import com.example.mvvm_example_kotlin.model.SaveDataEntity

class SaveRepositoryImpl(private val saveDao: SaveDao) : SaveRepository {
    override suspend fun get(): List<SaveDataEntity> {
        return saveDao.get()
    }

    override suspend fun insert(title: String, contents: String, url: String): Long {
        return saveDao.insert(SaveDataEntity(id=null,title,contents, url))
    }

}