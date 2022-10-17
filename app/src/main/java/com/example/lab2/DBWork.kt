package com.example.lab2

import android.annotation.SuppressLint
import android.content.Context
import com.example.lab2.model.Action
import com.example.lab2.view.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.*


class DBWork() {
    companion object {
        private val FILE_NAME = "actions.json"

        fun read(): MutableList<Action> {
            val file = File(MainActivity.appContext.filesDir, FILE_NAME)
            val fileReader = FileReader(file)
            val bufferedReader = BufferedReader(fileReader)
            val gson = Gson()

            val sType = object : TypeToken<MutableList<Action>>() {}.type

            return gson.fromJson<MutableList<Action>>(bufferedReader.readLine(), sType)


        }

        fun save(actions: MutableList<Action>) {
            val gson = Gson()

            val userString: String = gson.toJson(actions)
            val file = File(MainActivity.appContext.filesDir, FILE_NAME)
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(userString)
            bufferedWriter.close()


        }
    }
}