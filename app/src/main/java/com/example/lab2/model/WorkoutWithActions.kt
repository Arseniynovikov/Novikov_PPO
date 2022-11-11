package com.example.lab2.model

import androidx.room.Embedded
import androidx.room.Relation

data class WorkoutWithActions(
    @Embedded
    val workout: Workout,

    @Relation(parentColumn = "id", entityColumn = "workout_id")
    val actions: List<Action>
)