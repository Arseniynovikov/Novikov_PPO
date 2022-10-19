package com.example.lab2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.DBWork
import com.example.lab2.model.Action

class NewWorkOutViewModel() : ViewModel() {

    private var _actionData = MutableLiveData<MutableList<Action>>()
    var actionData
        get() = _actionData
        set(value){
            _actionData = value
        }

    fun addElem(){
        val list = actionData.value!!
        list.add(Action("", 0))
        actionData.value = list
    }

}