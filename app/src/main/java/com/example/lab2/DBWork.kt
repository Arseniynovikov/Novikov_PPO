package com.example.lab2

import com.example.lab2.model.Action
import com.example.lab2.model.Workout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.*


class DBWork() {
    companion object {
        private val FILE_NAME = "works.json"

        fun read()/*: MutableList<Workout>?*/ {
//            val file = File(MainActivity.appContext.filesDir, FILE_NAME)
//            return if(file.exists()) {
//                val fileReader = FileReader(file)
//                val bufferedReader = BufferedReader(fileReader)
//                val gson = Gson()
//
//                val sType = object : TypeToken<MutableList<Action>>() {}.type
//
//
//                gson.fromJson<MutableList<Workout>>(bufferedReader.readLine(), sType)
//            }else{
//                null
//            }
//

        }

        fun save(works: MutableList<Workout>) {
//            val gson = Gson()
//
//            val userString: String = gson.toJson(works)
//            val file = File(MainActivity.appContext.filesDir, FILE_NAME)
//            val fileWriter = FileWriter(file)
//            val bufferedWriter = BufferedWriter(fileWriter)
//            bufferedWriter.write(userString)
//            bufferedWriter.close()


        }
    }
}