package com.example.lab2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

//@Entity(
//    tableName = "actions"
//    )
//open class Action() {
//    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0
//
//    @ColumnInfo
//    private var _name: String = ""
//    var name: String
//        get() = _name
//        set(value) {
//            _name = value
//        }
//
//    @ColumnInfo
//    private var _time: Int = 0
//    var time: Int
//        get() = _time
//        set(value) {
//            if (value >= 0)
//                _time = value
//        }
//
//
//    constructor(name: String, time: Int) : this() {
//        this._time = time
//        this._name = name
//    }
//}
@Entity(tableName = "actions")
data class Action(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var time: Int,
    var workout_id: Int
)