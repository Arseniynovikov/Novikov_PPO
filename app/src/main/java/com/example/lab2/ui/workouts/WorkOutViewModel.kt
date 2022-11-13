package com.example.lab2.ui.workouts

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lab2.db.WorkoutDataBase
import com.example.lab2.db.WorkoutsRepository
import com.example.lab2.model.ActionModel
import com.example.lab2.model.Workout
import com.example.lab2.model.WorkoutModel
import com.example.lab2.model.WorkoutWithActions
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class WorksOutViewModel(application: Application) : AndroidViewModel(application) {
    val context = application
    private val dataBase = WorkoutDataBase.getInstance(context)
    private val repository = WorkoutsRepository(dataBase.getWorkoutDao())

    private var _workout = MutableLiveData<List<Workout>>()
    val workout: LiveData<List<Workout>> = _workout

    fun initWorkouts() {
        val workout = WorkoutsRepository.takeWorkouts(context)
        Log.w("tag", "database.isOpen = ${dataBase.isOpen}\nworkout.value = ${workout.value}")


//        _workout.value = WorkoutsRepository.takeWorkouts(context).value ?: listOf(
//            Workout(
//                name = "a",
//                listOf(ActionModel(name = "2", time = 2, workout_id = 1))
//            )
//        )

    }

    suspend fun add() {

        //repository.insertWorkout(WorkoutModel(name = "d"))
        initWorkouts()
    }
}