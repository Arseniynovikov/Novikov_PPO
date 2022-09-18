package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


interface OnSelectedButtonListener {
    fun onButtonSelected(btnIndex: Int)
}

class KeyboardFragment : Fragment(), View.OnClickListener {

    var checkPoint: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn1: Button = view.findViewById(R.id.btn1)
        val btn2: Button = view.findViewById(R.id.btn2)
        val btn3: Button = view.findViewById(R.id.btn3)
        val btn4: Button = view.findViewById(R.id.btn4)
        val btn5: Button = view.findViewById(R.id.btn5)
        val btn6: Button = view.findViewById(R.id.btn6)
        val btn7: Button = view.findViewById(R.id.btn7)
        val btn8: Button = view.findViewById(R.id.btn8)
        val btn9: Button = view.findViewById(R.id.btn9)
        val btn0: Button = view.findViewById(R.id.btn0)
        val btnPoint: Button = view.findViewById(R.id.btnPoint)
        val btnClean: Button = view.findViewById(R.id.btnClean)

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
                if (checkPoint) {
                    index = 10
                    checkPoint = false
                }
            }
            R.id.btnClean -> {
                index = 11
                checkPoint = true
            }
        }

        return index
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keyboard, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment keyboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KeyboardFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}