package com.example.lab2.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lab2.model.ActionModel
import com.example.lab2.model.WorkoutModel
import com.example.lab2.model.WorkoutWithActions

@Dao
interface WorkoutDao {
    @Insert
    suspend fun insertWorkout(workout: WorkoutModel)

    @Insert
    suspend fun insertAction(action: ActionModel)

    @Delete
    suspend fun deleteWorkout(workout: WorkoutModel)

    @Delete
    suspend fun deleteAction(action: ActionModel)

    @Update
    suspend fun updateWorkout(workout: WorkoutModel)

    @Update
    suspend fun updateAction(action: ActionModel)

    @Query("SELECT * from workouts")
    fun getWorkoutWithActions(): LiveData<List<WorkoutWithActions>>
}