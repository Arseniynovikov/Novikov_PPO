package com.example.lab1

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment


class ConvertFragment : Fragment(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    private val duration = Toast.LENGTH_SHORT

    private lateinit var spnUnit: Spinner
    private lateinit var spnCh1: Spinner
    private lateinit var spnCh2: Spinner
    private lateinit var txtInput: EditText
    private lateinit var txtOut: EditText
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


    private var textFromInputEdit = StringBuilder("")
    private var positionInInputEdit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            converter = savedInstanceState.getSerializable("converter") as Converter
            spn1Selected = savedInstanceState.getString("spn1Selected").toString()
            spn2Selected = savedInstanceState.getString("spn2Selected").toString()
            arrayUnitSelected =
                savedInstanceState.getStringArray("arrayUnitSelected") as Array<String>
            spn1Number = savedInstanceState.getInt("spn1Number")
            spn2Number = savedInstanceState.getInt("spn2Number")
            textFromInputEdit = StringBuilder(savedInstanceState.getString("txtInput").toString())
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spnUnit = view.findViewById(R.id.spnUnit)
        spnCh1 = view.findViewById(R.id.spnCh1)
        spnCh2 = view.findViewById(R.id.spnCh2)

        txtInput = view.findViewById(R.id.txtInput)
        txtInput.showSoftInputOnFocus = false
        registerForContextMenu(txtInput);


        txtOut = view.findViewById(R.id.txtOutput)
        txtOut.showSoftInputOnFocus = false

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

        positionInInputEdit = txtInput.selectionStart

        when (buttonIndex) {
            0 -> {
                textFromInputEdit.insert(positionInInputEdit, "0")
            }
            1 -> {
                textFromInputEdit.insert(positionInInputEdit, "1")
            }
            2 -> {
                textFromInputEdit.insert(positionInInputEdit, "2")
            }
            3 -> {
                textFromInputEdit.insert(positionInInputEdit, "3")
            }
            4 -> {
                textFromInputEdit.insert(positionInInputEdit, "4")
            }
            5 -> {
                textFromInputEdit.insert(positionInInputEdit, "5")
            }
            6 -> {
                textFromInputEdit.insert(positionInInputEdit, "6")
            }
            7 -> {
                textFromInputEdit.insert(positionInInputEdit, "7")
            }
            8 -> {
                textFromInputEdit.insert(positionInInputEdit, "8")
            }
            9 -> {
                textFromInputEdit.insert(positionInInputEdit, "9")
            }
            10 -> {
                if (!textFromInputEdit.contains(".")) {
                    if (textFromInputEdit.isEmpty()) {
                        textFromInputEdit.append("0.")
                        positionInInputEdit += 1
                    } else
                        textFromInputEdit.insert(positionInInputEdit, ".")
                }
                else {
                    Toast.makeText(context, "точка уже есть", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            11 -> {
                if (positionInInputEdit >= 1) {
                    textFromInputEdit.deleteCharAt(positionInInputEdit - 1)
                    positionInInputEdit -= 2
                } else return
            }
            12 -> {
                textFromInputEdit.clear()
                txtInput.text.clear()
                positionInInputEdit = 0
                txtOut.text.clear()
                return
            }
        }
        positionInInputEdit += 1
        txtInput.setText(textFromInputEdit)
        txtInput.setSelection(positionInInputEdit)

        txtOut.setText(converter.convert(spn1Selected, spn2Selected, txtInput.text.toString()))


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_convert, container, false)
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, number: Int, p3: Long) {
        if (view != null) {
            when (p0!!.id) {
                R.id.spnUnit -> {
                    selectedUnit(number, view)
                }

                R.id.spnCh1 -> {
                    spn1Selected = arrayUnitSelected[number]
                    spn1Number = number
                    Log.w(tag, "$number")
                }
                R.id.spnCh2 -> {
                    spn2Selected = arrayUnitSelected[number]
                    spn2Number = number
                    Log.w(tag, "$number")
                }
            }

            txtOut.setText(converter.convert(spn1Selected, spn2Selected, txtInput.text.toString()))


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
                    copy(txtInput.text.toString())
                }
                R.id.btnOutCopy -> {
                    copy(txtOut.text.toString())
                }
            }
        }
    }

    private fun exchange() {
        spn1Selected = arrayUnitSelected[spn2Number]
        spn2Selected = arrayUnitSelected[spn1Number]

        var buf = txtOut.text.toString()

        while (true)
            if ("." in buf && buf.last() == '0' && buf[buf.length - 2] != '.') {
                buf = buf.dropLast(1)
            } else {
                break
            }

        val bufNum = spn1Number
        spn1Number = spn2Number
        spn2Number = bufNum

        spnCh1.setSelection(spn1Number)
        spnCh2.setSelection(spn2Number)


        txtInput.setText(buf)

    }
    private fun copy(text: String) {
        clipboardManager =
            activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipData = ClipData.newPlainText("text", text)
        clipboardManager.setPrimaryClip(clipData)

        val toast = Toast.makeText(context, "скопировано!", duration)
        toast.show()
    }

    private fun paste() {
        positionInInputEdit = txtInput.selectionStart

        val bufTxt = clipboardManager.primaryClip?.getItemAt(0)?.text

        if(bufTxt.toString().contains(".") && textFromInputEdit.toString().contains(".")){
            Toast.makeText(context, "при вставке будет две точки", Toast.LENGTH_SHORT).show()
            return
        }

        textFromInputEdit.insert(positionInInputEdit, bufTxt)
        txtInput.setText(textFromInputEdit.toString())

        positionInInputEdit += bufTxt!!.length
        txtInput.setSelection(positionInInputEdit)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable("converter", converter)
        outState.putString("spn1Selected", spn1Selected)
        outState.putString("spn2Selected", spn2Selected)
        outState.putStringArray("arrayUnitSelected", arrayUnitSelected)
        outState.putInt("spn1Number", spn1Number)
        outState.putInt("spn2Number", spn2Number)
        outState.putString("txtInput", textFromInputEdit.toString())

    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = MenuInflater(context)
        inflater.inflate(R.menu.menu_edit, menu)
        menu.setHeaderTitle("Select The Action")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if(item.itemId ==R.id.paste){
            paste()
        }else{
            return false;
        }
        return true;
    }


}


