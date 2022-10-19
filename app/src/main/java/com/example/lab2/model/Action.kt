package com.example.lab2.model

open class Action() {

    private var _name: String = ""
    var name: String
        get() = _name
        set(value) {
            _name = value
        }

    private var _time: Int = 0
    open var time: Int
        get() = _time
        set(value) {
            if (value >= 0)
                _time = value
        }

    constructor(name: String, time: Int) : this() {
        this._time = time
        this._name = name
    }
}