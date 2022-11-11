package com.example.lab1_1


import android.R
import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText


class MyEditText(context: Context, attrs: AttributeSet?, defStyle: Int) :
    AppCompatEditText(context, attrs, defStyle) {

    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        android.R.attr.editTextStyle
    )

    constructor(context: Context) : this(context, null)

    override fun onTextContextMenuItem(id: Int): Boolean {
        // Do your thing:
        // Do your thing:
        var consumed = false
        // React:
        when (id) {
            R.id.cut -> {
                Toast.makeText(context, "You can't cut this string.", Toast.LENGTH_SHORT).show()
                consumed = false

            }
            R.id.paste -> if (paste()) {
                val bufTxt = ConvertFragment.clipboardManager!!.primaryClip?.getItemAt(0)?.text
                ConvertFragment.positionInInputEdit = ConvertFragment.txtInput.selectionStart
                ConvertFragment.textFromInputEdit.insert(ConvertFragment.positionInInputEdit, bufTxt)
                ConvertFragment.txtInput.setText(ConvertFragment.textFromInputEdit)
            }
            R.id.copy -> {
                Toast.makeText(context, "Button for copy is joke for you?....", Toast.LENGTH_SHORT).show()
                consumed = false
            }
        }
        return consumed
    }

    private fun paste(): Boolean {
        if (ConvertFragment.clipboardManager != null) {

            val bufTxt = ConvertFragment.clipboardManager!!.primaryClip?.getItemAt(0)?.text
            Toast.makeText(context, "$bufTxt", Toast.LENGTH_SHORT).show()

            if (bufTxt.toString().contains(".") && ConvertFragment.textFromInputEdit.toString()
                    .contains(".")
            ) {
                Toast.makeText(
                    context,
                    "can't paste this because of second point",
                    Toast.LENGTH_SHORT
                )
                    .show()
                return false
            }

            try {
                val buf_d = bufTxt.toString().toBigDecimal()

            } catch (e: java.lang.NumberFormatException) {

                Toast.makeText(
                    context,
                    "should only be numbers",
                    Toast.LENGTH_SHORT
                )
                    .show()
                return false

            }

            ConvertFragment.positionInInputEdit += bufTxt!!.length
            return true

        } else {
            Toast.makeText(context, "Clip board is empty", Toast.LENGTH_SHORT).show()
            return false
        }
    }

}