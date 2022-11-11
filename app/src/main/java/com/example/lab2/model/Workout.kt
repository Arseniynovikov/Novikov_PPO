package com.example.lab2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "workouts")
//class Workout(name: String, actionList: List<Action>) {
//    @PrimaryKey(autoGenerate = true)
//    var id : Int = 0
//
//    @ColumnInfo
//    private var _name = name
//    var name
//        get() = _name
//        set(value) {
//            _name = value
//        }
//
//    @ColumnInfo
//    private var _action = actionList
//    var action
//        get() = _action
//        set(value) {
//            _action = value
//        }
//
//    @ColumnInfo
//    private var _fullTime = timeOfWork()
//    var fullTime
//        get() = _fullTime
//        set(value) {
//            _fullTime = value
//        }
//
//
//    private fun timeOfWork(): Int{
//        var sum = 0
//        _action.forEach{
//            sum += it.time
//        }
//        return sum
//    }
//
//
//
//}

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var name: String
)