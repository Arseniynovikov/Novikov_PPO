package com.example.lab1

import java.lang.Exception

class ConverterWeights: Converter() {
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
            if (from_unit == "tons" && to_unit == "kilograms") {
                convertOperation = {v: Double -> v * 1000}
            }
            else if(from_unit == "tons" && to_unit == "grams") {
                convertOperation = {v: Double -> v * 1000000}
            }
            else if(from_unit == "tons" && to_unit == "tons") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "kilograms" && to_unit == "grams") {
                convertOperation = {v: Double -> v * 1000}
            }
            else if(from_unit == "kilograms" && to_unit == "tons") {
                convertOperation = {v: Double -> v * 0.0001}
            }
            else if(from_unit == "kilograms" && to_unit == "kilograms") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "grams" && to_unit == "tons") {
                convertOperation = {v: Double -> v * 0.000001}
            }
            else if(from_unit == "grams" && to_unit == "kilograms") {
                convertOperation = {v: Double -> v * 0.001}
            }
            else if(from_unit == "grams" && to_unit == "grams") {
                convertOperation = {v: Double -> v}
            }
        }

        return convertOperation(valueDouble).toString()
    }
}