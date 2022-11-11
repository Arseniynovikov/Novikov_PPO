package com.example.lab2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab2.db.dao.WorkoutDao
import com.example.lab2.model.Action
import com.example.lab2.model.Workout

@Database(entities = [Workout::class, Action::class], version = 2)
abstract class WorkoutDataBase: RoomDatabase() {
    abstract fun getWorkoutDao(): WorkoutDao

    companion object{
        private var database: WorkoutDataBase ?= null

        @Synchronized
        fun getInstance(context: Context): WorkoutDataBase{
            return if(database == null){
                database = Room.databaseBuilder(context, WorkoutDataBase::class.java, "db").build()
                database as WorkoutDataBase
            }else{
                database as WorkoutDataBase
            }
        }
    }
}