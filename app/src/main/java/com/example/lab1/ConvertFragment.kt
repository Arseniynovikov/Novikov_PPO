package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import java.lang.reflect.Array

class ConvertFragment : Fragment(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    private lateinit var spnUnit: Spinner
    private lateinit var spnCh1: Spinner
    private lateinit var spnCh2: Spinner
    private lateinit var txtInput: TextView
    private lateinit var txtOut: TextView
    private lateinit var btnExchange: Button

    private lateinit var converter: Converter

    private lateinit var spnUnitSelected: String
    private var spn1Selected: String = ""
    private var spn2Selected: String = ""
    private lateinit var arrayUnitSelected: kotlin.Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spnUnit = view.findViewById(R.id.spnUnit)
        spnCh1 = view.findViewById(R.id.spnCh1)
        spnCh2 = view.findViewById(R.id.spnCh2)

        txtInput = view.findViewById(R.id.txtInput)
        txtOut = view.findViewById(R.id.txtOutput)
        btnExchange = view.findViewById(R.id.btnExchange)

        spnUnit.onItemSelectedListener = this
        spnCh1.onItemSelectedListener = this
        spnCh2.onItemSelectedListener = this

        btnExchange.setOnClickListener(this)
    }

    fun setDescription(buttonIndex: Int) {
        when (buttonIndex) {
            0 -> txtInput.append("0")
            1 -> txtInput.append("1")
            2 -> txtInput.append("2")
            3 -> txtInput.append("3")
            4 -> txtInput.append("4")
            5 -> txtInput.append("5")
            6 -> txtInput.append("6")
            7 -> txtInput.append("7")
            8 -> txtInput.append("8")
            9 -> txtInput.append("9")
            10 -> txtInput.append(".")
            11 -> txtInput.text = ""
        }

        txtOut.text = converter.convert(spn1Selected, spn2Selected, txtInput.text.toString())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_convert, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ConvertF.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConvertFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, number: Int, p3: Long) {
        if (p0!!.id == R.id.spnUnit) {
            if (view != null) {
                var adapter: ArrayAdapter<CharSequence>? = null
                when (number) {
                    0 -> {
                        spnUnitSelected = "Weights"
                        arrayUnitSelected = resources.getStringArray(R.array.weights)
                        adapter = ArrayAdapter.createFromResource(
                            view.context,
                            R.array.weights,
                            android.R.layout.simple_spinner_item
                        )
                    }
                    1 -> {
                        spnUnitSelected = "Distance"
                        arrayUnitSelected = resources.getStringArray(R.array.distance)
                        adapter = ArrayAdapter.createFromResource(
                            view.context,
                            R.array.distance,
                            android.R.layout.simple_spinner_item
                        )
                    }
                    2 -> {
                        spnUnitSelected = "Currency"
                        arrayUnitSelected = resources.getStringArray(R.array.currency)
                        adapter = ArrayAdapter.createFromResource(
                            view.context,
                            R.array.currency,
                            android.R.layout.simple_spinner_item
                        )
                    }
                }

                converter = Converter.returnConverter(spnUnitSelected)!!
                adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spnCh1.adapter = adapter
                spnCh2.adapter = adapter
            }
        } else if (p0.id == R.id.spnCh1) {
            spn1Selected = arrayUnitSelected[number]
        } else if (p0.id == R.id.spnCh2) {
            spn2Selected = arrayUnitSelected[number]
        }
        txtOut.text = converter.convert(spn1Selected, spn2Selected, txtInput.text.toString())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onClick(view: View?) {
        TODO("реализовать перекидываение выбранных значений")

    }
}