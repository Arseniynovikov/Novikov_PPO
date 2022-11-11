package com.example.lab2.ui.workouts

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lab2.db.WorkoutDataBase
import com.example.lab2.model.Action
import com.example.lab2.model.Workout
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WorksOutViewModel(application: Application) : AndroidViewModel(application) {
    val context = application
    private val dataBase = WorkoutDataBase.getInstance(context)

    private val _workout = MutableLiveData<List<Workout>>()
    val workout: LiveData<List<Workout>> = _workout

    init{
        takeDataFromRepository()
    }

    private fun takeDataFromRepository() {
        runBlocking {
            val bufData = dataBase.getWorkoutDao().getWorkoutWithActions(0)
            Log.w("tag", "$bufData")
        }
    }


    suspend fun add() = coroutineScope {
        launch {
            dataBase.getWorkoutDao().insertWorkout(Workout(name = "skdjos"))
            dataBase.getWorkoutDao().insertAction(Action(name = "aojidf", time = 1, workout_id = 0))
        }
    }


}