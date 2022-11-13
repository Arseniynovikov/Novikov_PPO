package com.example.lab2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actions")
data class ActionModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var time: Int,
    var workout_id: Int
)