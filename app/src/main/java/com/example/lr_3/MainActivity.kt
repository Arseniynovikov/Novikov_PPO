package com.example.lr_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lr_3.input_output.InputOutputFragment
import com.example.lr_3.input_output.OnSelectedButtonListener

class MainActivity : AppCompatActivity(), OnSelectedButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonSelected(btnIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager = supportFragmentManager

        // Получаем ссылку на второй фрагмент по ID
        val fragment2 = fragmentManager.findFragmentById(R.id.input_output) as InputOutputFragment?
        fragment2?.setDescription(btnIndex)
    }
}