package com.example.lab2.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.DBWork
import com.example.lab2.model.Action

class MainMenuViewModel(actionDataList: MutableList<Action>) : ViewModel() {

    private var _actionData = MutableLiveData<MutableList<Action>>()
    var actionData
        get() = _actionData
        set(value){
            _actionData = value
        }

    init {
        _actionData.value = actionDataList
    }

}