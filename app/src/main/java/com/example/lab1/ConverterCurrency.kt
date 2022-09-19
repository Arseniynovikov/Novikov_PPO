package com.example.lab1

import java.lang.Exception

class ConverterCurrency: Converter() {
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
            if (from_unit == "dollars" && to_unit == "dollars") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "dollars" && to_unit == "euro") {
                convertOperation = {v: Double -> v * 1.0026}
            }
            else if(from_unit == "dollars" && to_unit == "rubles") {
                convertOperation = {v: Double -> v * 2.532}
            }
            else if(from_unit == "euro" && to_unit == "euro") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "euro" && to_unit == "dollars") {
                convertOperation = {v: Double -> v * 0.997}
            }
            else if(from_unit == "euro" && to_unit == "rubles") {
                convertOperation = {v: Double -> v * 2.525}
            }
            else if(from_unit == "rubles" && to_unit == "rubles") {
                convertOperation = {v: Double -> v}
            }
            else if(from_unit == "rubles" && to_unit == "dollars") {
                convertOperation = {v: Double -> v * 0.3949}
            }
            else if(from_unit == "rubles" && to_unit == "euro") {
                convertOperation = {v: Double -> v * 0.396}
            }
        }

        return convertOperation(valueDouble).toString()
    }
}