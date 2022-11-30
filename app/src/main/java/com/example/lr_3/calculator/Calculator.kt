package com.example.lr_3.calculator

import android.content.Context
import android.widget.Toast


 class Calculator(private val context: Context) {


    fun calculate(string: String): String {
        try {
            val result = ExpressionBuilder(string).build().evaluate()
            val longRes = result.toLong()

            return if (result == longRes.toBigDecimal())
                longRes.toString()
            else
                result.toString()

        } catch (e: Exception) {
            Toast.makeText(context, "Incorrect input.", Toast.LENGTH_SHORT).show()
        }
        return "0"
    }




 }