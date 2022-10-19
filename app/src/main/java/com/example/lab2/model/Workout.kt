package com.example.lab2.model

class Workout(name: String, actionList: MutableList<Action>) {

    private var _name = name
    var name
        get() = _name
        set(value) {
            _name = value
        }

    private var _action = actionList
    var action
        get() = _action
        set(value) {
            _action = value
        }

    private var _fullTime = timeOfWork()
    var fullTime
        get() = _fullTime
        set(value) {
            _fullTime = value
        }


    private fun timeOfWork(): Int{
        var sum = 0
        _action.forEach{
            sum += it.time
        }
        return sum
    }
}