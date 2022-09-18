package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class MainActivity : AppCompatActivity(), OnSelectedButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonSelected(btnIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager = supportFragmentManager

        // Получаем ссылку на второй фрагмент по ID
        val fragment2 = fragmentManager.findFragmentById(R.id.cunvert_fragment) as ConvertFragment?
        fragment2?.setDescription(btnIndex)
    }
}
/**
 * перекидываение значений
 * избавиться от округления
 * реализовать копирование в буфер обмена
 * пофиксить фронт
 */