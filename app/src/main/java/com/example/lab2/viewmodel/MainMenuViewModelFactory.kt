package com.example.lab2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.DBWork

class MainMenuViewModelFactory(context: Context?) : ViewModelProvider.Factory {

    val contextOut = context

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainMenuViewModel(DBWork.read(contextOut!!)) as T
    }

}