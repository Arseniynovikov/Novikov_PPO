package com.example.lr_3.input_output

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lr_3.calculator.Calculator
import com.example.lr_3.databinding.FragmentInputOutputBinding

interface OnSelectedButtonListener {
    fun onButtonSelected(btnIndex: Int)
}

class InputOutputFragment : Fragment() {
    private lateinit var viewModel: InputOutputViewModel
    private lateinit var binding: FragmentInputOutputBinding
    private lateinit var calculator: Calculator

    private lateinit var editText: EditText

    private var position = 0

    private var string = StringBuilder("")
    private var pointCheck = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position")
            string = StringBuilder(savedInstanceState.getString("string")!!)
            pointCheck = savedInstanceState.getBoolean("point")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = binding.editText
        editText.showSoftInputOnFocus = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[InputOutputViewModel::class.java]
        binding = FragmentInputOutputBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    fun setDescription(buttonIndex: Int) {
        calculator = Calculator(this.requireContext())
        position = editText.selectionStart


        string = StringBuilder(editText.text.toString())

        when (buttonIndex) {
            0 -> if (checkInput("0")) {
                string.insert(position, "0")
            } else {
                return
            }
            1 -> {
                string.insert(position, "1")
            }
            2 -> {
                string.insert(position, "2")
            }
            3 -> {
                string.insert(position, "3")
            }
            4 -> {
                string.insert(position, "4")
            }
            5 -> {
                string.insert(position, "5")
            }
            6 -> {
                string.insert(position, "6")
            }
            7 -> {
                string.insert(position, "7")
            }
            8 -> {
                string.insert(position, "8")
            }
            9 -> {
                string.insert(position, "9")
            }
            10 -> if (checkInput("+") && string.isNotEmpty()) {
                string.insert(position, "+")
                pointCheck = true
            } else {
                return
            }
            11 -> if (checkInput("-")) {
                string.insert(position, "-")
                pointCheck = true
            } else {
                return
            }
            12 -> if (checkInput("*") && string.isNotEmpty()) {
                string.insert(position, "*")
                pointCheck = true
            } else {
                return
            }
            13 -> if (checkInput("/") && string.isNotEmpty()) {
                string.insert(position, "/")
                pointCheck = true
            } else {
                return
            }
            14 -> {
                pointCheck = true
                string.clear()
                position = -1

            }
            15 -> if (string.isNotEmpty()) {
                delete()
            } else return

            16 -> if (pointCheck) {
                string.insert(position, ".")
                pointCheck = false
            } else {
                return
            }
            17 -> {
                editText.setText(calculator.calculate(string.toString()))
                string = StringBuilder(editText.text.toString())
                position = string.length - 1
            }
            18 -> if (simCheck()) {
                if (string[0] != '-') {
                    string.insert(0, "-")
                } else {
                    string.deleteCharAt(0)
                    position -= 2
                }
            } else {
                return

            }
            19 -> {
                string.insert(position, "(")
            }
            20 -> {
                string.insert(position, ")")
            }
            21 -> {
                string.insert(position, "sin()")
                position += 3
            }
            22 -> {
                string.insert(position, "cos()")
                position += 3
            }
            23 -> {
                string.insert(position, "tan()")
                position += 3
            }
            24 -> {
                string.insert(position, "cot()")
                position += 3
            }
            25 -> {
                string.insert(position, "ln()")
                position += 2
            }
            26 -> {
                string.insert(position, "log()")
                position += 3
            }
            27 -> {
                string.insert(position, "!")

            }
            28 -> {
                string.insert(position, "sqrt()")
                position += 4
            }
            29 -> {
                string.insert(position, "^2")
                position += 1
            }
            30 -> {
                string.insert(position, "2^")
                position += 1
            }
            31 -> {
                string.insert(position, "10^")
                position += 2
            }
            32 -> {
                string.clear()
                position = -1
            }
            33 -> {
                string.insert(position, "exp()")
                position += 3
            }
            34 -> position += if (lastCheck()) {
                string.insert(position, "2.7182818284")
                11
            } else {
                string.insert(position, "*2.7182818284")
                12
            }
            35 -> position += if (lastCheck()) {
                string.insert(position, "3.1415926535")
                11
            } else {
                string.insert(position, "*3.1415926535")
                12
            }
            36 -> {
                string.insert(position, "^3")
                position += 1
            }
            37 -> {
                string.insert(position, "1/()")
                position += 2
            }
        }

        position += 1
        editText.setText(string.toString())
        editText.setSelection(position)


    }

    private fun checkInput(inputPart: String): Boolean {
        if (string.isNotEmpty())
            if ((string[string.lastIndex] == '+' || string[string.lastIndex] == '-' || string[string.lastIndex] == '*' || string[string.lastIndex] == '/') &&
                (inputPart == "+" || inputPart == "-" || inputPart == "*" || inputPart == "/")
            ) {
                Toast.makeText(
                    context,
                    "The sign must be followed by a number or a parenthesis",
                    Toast.LENGTH_SHORT
                ).show()
                return false
            } else if (pointCheck && inputPart == "0" && string[string.lastIndex] == '0') {
                Toast.makeText(context, "Too many zeros", Toast.LENGTH_SHORT).show()
                return false
            }
        return true
    }

    private fun lastCheck(): Boolean {
        return if (string.isNotEmpty()) {
            string.last() == '+' || string.last() == '-' || string.last() == '*' || string.last() == '/'
        } else {
            true
        }
    }

    private fun simCheck(): Boolean {
        return if (string.isNotEmpty()) {
            val bufStr = string.substring(1)
            !(bufStr.contains('+') || bufStr.contains('-') || bufStr.contains('*') || bufStr.contains(
                '/'
            ))

        } else false

    }

    private fun delete() {
        if (position != 0)
            if (deletionCheck(string[position - 1])) {
                while(deletionCheck(string[position])){
                    string = string.deleteCharAt(position)
                }
                while (deletionCheck(string[position - 1])) {
                    string = string.deleteCharAt(position - 1)
                    position -= 1
                    if (position == 0) {
                        position = -1
                        return
                    }
                }

            } else {
                string = string.deleteCharAt(position - 1)
                position -= 2
                return
            }


    }

    private fun deletionCheck(ch: Char): Boolean {
        return !(ch.isDigit() || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == ')' || ch == '(')
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("position", position)
        outState.putString("string", string.toString())
        outState.putBoolean("point", pointCheck)
    }
}