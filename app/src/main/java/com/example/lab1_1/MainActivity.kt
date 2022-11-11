package com.example.lab1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab1_1.ConvertFragment
import com.example.lab1_1.OnSelectedButtonListener

class MainActivity : AppCompatActivity(), OnSelectedButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonSelected(btnIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager = supportFragmentManager

        // Получаем ссылку на второй фрагмент по ID
        val fragment2 = fragmentManager.findFragmentById(R.id.convert_fragment) as ConvertFragment?
        fragment2?.setDescription(btnIndex)
    }
}
