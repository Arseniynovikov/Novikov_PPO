package com.example.lab2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.DBWork

//class ViewModelFactory(context: Context?) : ViewModelProvider.Factory {
//
//    private val contextOut = context
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return NewWorkOutViewModel(DBWork.read(contextOut!!)) as T
//    }
//
//}