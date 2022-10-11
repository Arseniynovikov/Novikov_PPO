package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


interface OnSelectedButtonListener {
    fun onButtonSelected(btnIndex: Int)
}

class KeyboardFragment : Fragment(), View.OnClickListener {

    private var hasPoint: Boolean = true

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnPoint: Button
    private lateinit var btnClean: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1 = view.findViewById(R.id.btn1)
        btn2 = view.findViewById(R.id.btn2)
        btn3 = view.findViewById(R.id.btn3)
        btn4 = view.findViewById(R.id.btn4)
        btn5 = view.findViewById(R.id.btn5)
        btn6 = view.findViewById(R.id.btn6)
        btn7 = view.findViewById(R.id.btn7)
        btn8 = view.findViewById(R.id.btn8)
        btn9 = view.findViewById(R.id.btn9)
        btn0 = view.findViewById(R.id.btn0)
        btnPoint = view.findViewById(R.id.btnPoint)
        btnClean = view.findViewById(R.id.btnClean)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnPoint.setOnClickListener(this)
        btnClean.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val btnIndex = fromIdToIndex(p0!!.id)

        val listener = activity as OnSelectedButtonListener?
        listener?.onButtonSelected(btnIndex)
    }

    private fun fromIdToIndex(id: Int): Int {
        var index = -1
        when (id) {
            R.id.btn0 -> index = 0
            R.id.btn1 -> index = 1
            R.id.btn2 -> index = 2
            R.id.btn3 -> index = 3
            R.id.btn4 -> index = 4
            R.id.btn5 -> index = 5
            R.id.btn6 -> index = 6
            R.id.btn7 -> index = 7
            R.id.btn8 -> index = 8
            R.id.btn9 -> index = 9
            R.id.btnPoint -> {
                if (hasPoint) {
                    index = 10
                    hasPoint = false

                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, "точка уже есть", duration)
                    toast.show()
                }
            }
            R.id.btnClean -> {
                index = 11
                hasPoint = true
            }
        }

        return index
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            hasPoint = savedInstanceState.getBoolean("hasPoint")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keyboard, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("hasPoint", hasPoint)
    }

}