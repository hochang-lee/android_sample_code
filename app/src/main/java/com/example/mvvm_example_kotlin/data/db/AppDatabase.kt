package com.example.mvvm_example_kotlin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_example_kotlin.data.db.dao.SaveDao
import com.example.mvvm_example_kotlin.data.db.entity.SaveDataEntity

@Database(entities = [SaveDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SaveDao
}
