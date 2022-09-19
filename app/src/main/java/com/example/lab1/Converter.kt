package com.example.lab1

import java.io.Serializable

abstract class Converter() : Serializable {
    abstract fun convert(from_unit: String, to_unit: String, value: String): String

    companion object {
        fun returnConverter(unit: String): Converter? {
            return when (unit) {
                "Weights" -> ConverterWeights()
                "Distance" -> ConverterDistance()
                "Currency" -> ConverterCurrency()
                else -> null
            }
        }
    }
}