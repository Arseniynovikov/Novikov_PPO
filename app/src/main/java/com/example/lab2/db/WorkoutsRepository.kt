package com.example.lab2.db

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.lab2.db.dao.WorkoutDao
import com.example.lab2.model.ActionModel
import com.example.lab2.model.Workout
import com.example.lab2.model.WorkoutModel
import com.example.lab2.model.WorkoutWithActions
import kotlinx.coroutines.runBlocking

class WorkoutsRepository(private val workoutDao: WorkoutDao) {

    suspend fun insertWorkout(workout: WorkoutModel) =
        workoutDao.insertWorkout(WorkoutModel(name = workout.name))

    suspend fun insertAction(action: ActionModel) = workoutDao.insertAction(action)

    suspend fun deleteWorkout(workout: WorkoutModel) =
        workoutDao.deleteWorkout(WorkoutModel(name = workout.name))

    suspend fun deleteAction(action: ActionModel) = workoutDao.deleteAction(action)

    suspend fun updateWorkout(workout: WorkoutModel) =
        workoutDao.updateWorkout(WorkoutModel(name = workout.name))

    suspend fun updateAction(action: ActionModel) = workoutDao.updateAction(action)

    companion object {
        lateinit var dataBase: WorkoutDataBase

        var workouts: LiveData<List<Workout>>? = null

        @Synchronized
        fun takeWorkouts(context: Context): LiveData<List<Workout>> {
            dataBase = WorkoutDataBase.getInstance(context)
            return if (workouts == null) {
                workouts = Transformations.map(dataBase.getWorkoutDao().getWorkoutWithActions()) {
                    transformation(it)
                }
                workouts as LiveData<List<Workout>>
            } else {
                workouts as LiveData<List<Workout>>
            }

        }


        private fun transformation(workoutWithActions: List<WorkoutWithActions>): List<Workout> {
            val workoutList = mutableListOf<Workout>()
            for (workoutWithActionsIterator in workoutWithActions) {
                workoutList.add(
                    Workout(
                        workoutWithActionsIterator.workout.name,
                        workoutWithActionsIterator.actions
                    )
                )
            }

            return workoutList
        }
    }

}