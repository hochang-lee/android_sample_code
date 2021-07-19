package com.example.mvvm_example_kotlin.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SaveDataEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun searchDao(): SaveDao
}
