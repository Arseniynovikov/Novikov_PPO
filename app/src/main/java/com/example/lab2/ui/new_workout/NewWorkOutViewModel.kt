package com.example.lab2.ui.new_workout

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.model.Action
import com.example.lab2.model.Workout

interface WorkoutRepository {
    val workouts: LiveData<List<Workout>>
    fun save(workout: Workout)
}

class NewWorkOutViewModel(private val workoutRepository: WorkoutRepository) : ViewModel() {


    private val _actionData =
        MutableLiveData<List<Action>>(/*listOf(Action("a", 10), Action("d", 20))*/)
    val actionData: LiveData<List<Action>> = _actionData

    fun addElem() {
        //TODo new list

    }


    fun saveNewWorkOut(name: String) {
//        val workout = Workout(name, _actionData.value!!)
//        workoutRepository.save(workout)

    }

}