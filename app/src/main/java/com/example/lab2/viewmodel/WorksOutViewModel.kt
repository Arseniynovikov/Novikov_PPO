package com.example.lab2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.lab2.model.Action
import com.example.lab2.model.Workout

class WorksOutViewModel : ViewModel() {
    private var _workout = MutableLiveData<MutableList<Workout>>()
    var workout
        get() = _workout
        set(value){
            _workout = value
        }

    init {


        val actions = mutableListOf<Action>(Action("1", 12), Action("1", 13))
        _workout.value = mutableListOf(Workout("adf", actions))
        _workout.value!!.add(Workout("adiojfwie", actions))
    }


}