package com.example.lab2.model

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "workouts")
data class WorkoutModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name: String
)