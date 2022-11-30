package com.example.lr_3.basic_keyboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasicKeyboardViewModel: ViewModel() {
    val data = MutableLiveData<StringBuilder>()

    init{
        data.value = StringBuilder("")
    }
}