package com.example.lab2

import android.content.Context
import com.example.lab2.model.Action
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.*


class DBWork {
    companion object {
        private val FILE_NAME = "actions.json"

        fun read(context: Context?): MutableList<Action> {
            val file = File(context!!.filesDir, FILE_NAME)
            val fileReader = FileReader(file)
            val bufferedReader = BufferedReader(fileReader)
            val gson = Gson()

            val sType = object : TypeToken<MutableList<Action>>() {}.type

            return gson.fromJson<MutableList<Action>>(bufferedReader.readLine(), sType)


        }

        fun save(context: Context?, actions: MutableList<Action>) {
            val gson = Gson()

            val userString: String = gson.toJson(actions)
            val file = File(context!!.filesDir, FILE_NAME)
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(userString)
            bufferedWriter.close()


        }
    }
}