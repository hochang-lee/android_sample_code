package com.example.mvvm_example_kotlin.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_example_kotlin.data.db.entity.SaveDataEntity

@Dao
interface SaveDao {
    @Query("SELECT * FROM save")
    fun get(): List<SaveDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(saveData: SaveDataEntity): Long
}
