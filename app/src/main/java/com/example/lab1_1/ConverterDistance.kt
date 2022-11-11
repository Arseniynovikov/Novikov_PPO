package com.example.lab1_1

import java.lang.Exception
import java.math.BigDecimal

class ConverterDistance: Converter() {
    private val fromCh: String = ""
    private val toCh: String = ""
    private var convertOperation: ((BigDecimal) -> BigDecimal) = { v: BigDecimal -> v}

//    private var convertOperation: ((Double) -> Double) = {v: Double -> v}

    override fun convert(from_unit: String, to_unit: String, value: String): String {
        val valueDouble: BigDecimal
        try {
            valueDouble = value.toBigDecimal()

            println("str = $value\tdouble = $valueDouble\tlen=${value.length}")
//            valueDouble = value.toDouble()
        }
        catch (e: Exception){
            return ""
        }

        if (fromCh != from_unit || toCh != to_unit) {
            if (from_unit == "kilometers" && to_unit == "meters") {
                val buf = 1000.0
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "kilometers" && to_unit == "millimeters") {
                val buf = 1000000.0
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "kilometers" && to_unit == "kilometers") {
                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "meters" && to_unit == "millimeters") {
                val buf = 1000.0
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "meters" && to_unit == "kilometers") {
                val buf = 0.0001
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "meters" && to_unit == "meters") {
                convertOperation = {v: BigDecimal -> v}
            }
            else if(from_unit == "millimeters" && to_unit == "kilometers") {
                val buf = 0.000001
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "millimeters" && to_unit == "meters") {
                val buf = 0.001
                convertOperation = {v: BigDecimal -> v.multiply(buf.toString().toBigDecimal())}
            }
            else if(from_unit == "millimeters" && to_unit == "millimeters") {
                convertOperation = {v: BigDecimal -> v}
            }
        }


//        if (fromCh != from_unit || toCh != to_unit) {
//            if (from_unit == "kilometers" && to_unit == "kilometers") {
//                convertOperation = {v: Double -> v}
//            }
//            else if(from_unit == "kilometers" && to_unit == "meters") {
//                convertOperation = {v: Double -> v * 1000}
//            }
//            else if(from_unit == "kilometers" && to_unit == "millimeters") {
//                convertOperation = {v: Double -> v * 1000000}
//            }
//            else if(from_unit == "meters" && to_unit == "meters") {
//                convertOperation = {v: Double -> v}
//            }
//            else if(from_unit == "meters" && to_unit == "kilometers") {
//                convertOperation = {v: Double -> v * 0.0001}
//            }
//            else if(from_unit == "meters" && to_unit == "millimeters") {
//                convertOperation = {v: Double -> v * 1000}
//            }
//            else if(from_unit == "millimeters" && to_unit == "millimeters") {
//                convertOperation = {v: Double -> v}
//            }
//            else if(from_unit == "millimeters" && to_unit == "kilometers") {
//                convertOperation = {v: Double -> v * 0.000001}
//            }
//            else if(from_unit == "millimeters" && to_unit == "meters") {
//                convertOperation = {v: Double -> v * 0.001}
//            }
//        }

        return convertOperation(valueDouble).toString()
    }
}