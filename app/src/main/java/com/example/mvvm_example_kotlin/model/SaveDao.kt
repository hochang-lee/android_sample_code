package com.example.mvvm_example_kotlin.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SaveDao {
    @Query("SELECT * FROM save")
    fun get(): List<SaveDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(saveData: SaveDataEntity): Long
}
