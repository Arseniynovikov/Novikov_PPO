package com.example.lab1

import java.lang.Exception

class ConverterDistance: Converter() {
    private val fromCh: String = ""
    private val toCh: String = ""
    private var convertOperation: ((Double) -> Double) = {v: Double -> v}

    override fun convert(from_unit: String, to_unit: String, value: String): String {
        val valueDouble: Double
        try {
            valueDouble = value.toDouble()
        }
        catch (e: Exception){
            return ""
        }


        if (fromCh != from_unit || toCh != to_unit) {
            if (from_unit == "kilometers" && to_unit == "kilometers") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "kilometers" && to_unit == "meters") {
                convertOperation = {v: Double -> v * 1000}
            }
            else if(from_unit == "kilometers" && to_unit == "millimeters") {
                convertOperation = {v: Double -> v * 1000000}
            }
            else if(from_unit == "meters" && to_unit == "meters") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "meters" && to_unit == "kilometers") {
                convertOperation = {v: Double -> v * 0.0001}
            }
            else if(from_unit == "meters" && to_unit == "millimeters") {
                convertOperation = {v: Double -> v * 1000}
            }
            else if(from_unit == "millimeters" && to_unit == "millimeters") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "millimeters" && to_unit == "kilometers") {
                convertOperation = {v: Double -> v * 0.000001}
            }
            else if(from_unit == "millimeters" && to_unit == "meters") {
                convertOperation = {v: Double -> v * 0.001}
            }
        }

        return convertOperation(valueDouble).toString()
    }
}