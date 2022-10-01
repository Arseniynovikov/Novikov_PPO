package com.example.lab1

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class ConvertFragment : Fragment(), AdapterView.OnItemSelectedListener, View.OnClickListener{
    private lateinit var spnUnit: Spinner
    private lateinit var spnCh1: Spinner
    private lateinit var spnCh2: Spinner
    private lateinit var txtInput: TextView
    private lateinit var txtOut: TextView
    private lateinit var btnExchange: Button
    private lateinit var btnInputCopy: Button
    private lateinit var btnOutCopy: Button

    private lateinit var converter: Converter

    private lateinit var spnUnitSelected: String
    private var spn1Selected: String = ""
    private var spn2Selected: String = ""
    private var spn1Number: Int = 0
    private var spn2Number: Int = 0
    private lateinit var arrayUnitSelected: Array<String>

    private lateinit var clipboardManager: ClipboardManager
    private lateinit var clipData: ClipData

    private var ch = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.v(tag, "onCreate")


        if (savedInstanceState != null) {
            converter = savedInstanceState.getSerializable("converter") as Converter
            spn1Selected = savedInstanceState.getString("spn1Selected").toString()
            spn2Selected = savedInstanceState.getString("spn2Selected").toString()
            ch = savedInstanceState.getBoolean("ch")
            arrayUnitSelected =
                savedInstanceState.getStringArray("arrayUnitSelected") as Array<String>
            spn1Number = savedInstanceState.getInt("spn1Number")
            spn2Number = savedInstanceState.getInt("spn2Number")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(tag, "onViewCreated")


        spnUnit = view.findViewById(R.id.spnUnit)
        spnCh1 = view.findViewById(R.id.spnCh1)
        spnCh2 = view.findViewById(R.id.spnCh2)

        txtInput = view.findViewById(R.id.txtInput)
        txtOut = view.findViewById(R.id.txtOutput)
        btnExchange = view.findViewById(R.id.btnExchange)
        btnInputCopy = view.findViewById(R.id.btnInputCopy)
        btnOutCopy = view.findViewById(R.id.btnOutCopy)

        spnUnit.onItemSelectedListener = this
        spnCh1.onItemSelectedListener = this
        spnCh2.onItemSelectedListener = this


        btnExchange.setOnClickListener(this)
        btnInputCopy.setOnClickListener(this)
        btnOutCopy.setOnClickListener(this)
    }

    fun setDescription(buttonIndex: Int) {
        ch = true
        when (buttonIndex) {
            0 -> {
                println(txtInput.text)
                if (txtInput.text.toString() == "0") {

                    return
                }
                txtInput.append("0")
            }
            1 -> txtInput.append("1")
            2 -> txtInput.append("2")
            3 -> txtInput.append("3")
            4 -> txtInput.append("4")
            5 -> txtInput.append("5")
            6 -> txtInput.append("6")
            7 -> txtInput.append("7")
            8 -> txtInput.append("8")
            9 -> txtInput.append("9")
            10 -> {
                if (txtInput.text.toString() == "")
                    txtInput.append("0.")
                else
                    txtInput.append(".")
            }
            11 -> txtInput.text = ""
        }


        txtOut.text =
            converter.convert(spn1Selected, spn2Selected, txtInput.text.toString())


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_convert, container, false)
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, number: Int, p3: Long) {
        Log.w(tag, "onItemSelected")
        if (view != null && ch) {
            when (p0!!.id) {
                R.id.spnUnit -> {
                    selectedUnit(number, view)
                    Log.w(tag, "spnUnit")
                }

                R.id.spnCh1 -> {
                    spn1Selected = arrayUnitSelected[number]
                    spn1Number = number
                    Log.w(tag, "$number")
                }
                R.id.spnCh2 -> {
                    spn2Selected = arrayUnitSelected[number]
                    spn2Number = number
                }
            }
            txtOut.text =
                converter.convert(spn1Selected, spn2Selected, txtInput.text.toString())
        }


    }

    private fun selectedUnit(number: Int, view: View) {
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

        spn1Number = 0
        spn2Number = 0

        spnCh1.setSelection(spn1Number)
        spnCh2.setSelection(spn2Number)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.btnExchange -> {
                    exchange()
                }
                R.id.btnInputCopy -> {
                    copy()
                }
                R.id.btnOutCopy -> {
                    copy()
                }
            }
        }
    }

    private fun exchange() {
        ch = false
        lateinit var buf1 : String
        var buf2 = ""
        for (i in 0..2) {

            when(arrayUnitSelected[i]){
                spn1Selected -> {
                    spnCh2.setSelection(i)
                    buf2 = spn1Selected
                }
                spn2Selected -> {
                    spnCh1.setSelection(i)
                    buf1 = spn2Selected
                }
            }

        }
        spn1Selected = buf1
        spn2Selected = buf2


        val buf = txtInput.text
        txtInput.text = txtOut.text
        txtOut.text = buf

        val bufNum = spn1Number
        spn1Number = spn2Number
        spn2Number = bufNum

        spnCh1.setSelection(spn1Number)
        spnCh2.setSelection(spn2Number)

    }

    private fun copy() {
        clipboardManager =
            activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipData = ClipData.newPlainText("text", txtInput.text.toString())
        clipboardManager.setPrimaryClip(clipData)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable("converter", converter)
        outState.putString("spn1Selected", spn1Selected)
        outState.putString("spn2Selected", spn2Selected)
        outState.putStringArray("arrayUnitSelected", arrayUnitSelected)
        outState.putBoolean("ch", ch)
        outState.putInt("spn1Number", spn1Number)
        outState.putInt("spn2Number", spn2Number)

    }

}