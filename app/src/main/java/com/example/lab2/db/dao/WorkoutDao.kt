package com.example.lab2.db.dao

import androidx.room.*
import com.example.lab2.model.Action
import com.example.lab2.model.Workout
import com.example.lab2.model.WorkoutWithActions

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: Workout)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAction(action: Action)

    @Transaction
    @Query("SELECT * from workouts WHERE id = :workout_id")
    suspend fun getWorkoutWithActions(workout_id: Int): List<WorkoutWithActions>
}


//    @Delete
//    suspend fun deleteWorkout(workout: Workout)