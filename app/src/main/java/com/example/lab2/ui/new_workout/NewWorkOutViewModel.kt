package com.example.lab2.ui.new_workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.model.ActionModel
import com.example.lab2.model.WorkoutModel

interface WorkoutRepository {
    val workouts: LiveData<List<WorkoutModel>>
    fun save(workout: WorkoutModel)
}

class NewWorkOutViewModel(private val workoutRepository: WorkoutRepository) : ViewModel() {


    private val _actionData =
        MutableLiveData<List<ActionModel>>(/*listOf(Action("a", 10), Action("d", 20))*/)
    val actionData: LiveData<List<ActionModel>> = _actionData

    fun addElem() {
        //TODo new list

    }


    fun saveNewWorkOut(name: String) {
//        val workout = Workout(name, _actionData.value!!)
//        workoutRepository.save(workout)

    }

}