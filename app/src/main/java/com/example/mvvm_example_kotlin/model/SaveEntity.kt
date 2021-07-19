package com.example.mvvm_example_kotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "save")
data class SaveDataEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var title : String,
    var contents : String,
    var url : String
)