package com.example.lab2.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.viewmodel.MainViewModel
import com.example.lab2.R


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //context for work in DBWork
        appContext = applicationContext
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


    }

    companion object{
        lateinit var appContext: Context
    }


}