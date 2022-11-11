package com.example.lab1

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.MenuInflater
import androidx.appcompat.widget.AppCompatEditText


class MyEditText(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
: AppCompatEditText(context, attributeSet, defStyleAttr, defStyleRes) {

    constructor(context: Context) : this(context, null, 0, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int)
    : this(context, attributeSet, defStyleAttr, 0)

    init {
        inputType = InputType.TYPE_CLASS_NUMBER + InputType.TYPE_NUMBER_FLAG_DECIMAL
    }

    override fun onCreateContextMenu(menu: ContextMenu?) {
        val inflater = MenuInflater(context)
        inflater.inflate(R.menu.menu_edit, menu)
    }
}