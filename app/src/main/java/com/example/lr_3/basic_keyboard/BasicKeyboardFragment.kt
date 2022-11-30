package com.example.lr_3.basic_keyboard

import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.lr_3.R
import com.example.lr_3.databinding.FragmentBasicKeyboardBinding
import com.example.lr_3.databinding.FragmentInputOutputBinding
import com.example.lr_3.input_output.InputOutputViewModel
import com.example.lr_3.input_output.OnSelectedButtonListener


class BasicKeyboardFragment : Fragment(), View.OnClickListener {
    private lateinit var viewModel: BasicKeyboardViewModel
    private lateinit var binding: FragmentBasicKeyboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonChange.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_basicKeyboardFragment_to_secondKeyboardFragment)
        }

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.button0.setOnClickListener(this)
        binding.buttonPlus.setOnClickListener(this)
        binding.buttonMinus.setOnClickListener(this)
        binding.buttonMultiply.setOnClickListener(this)
        binding.buttonDivide.setOnClickListener(this)
        binding.buttonC.setOnClickListener(this)
        binding.buttonDel.setOnClickListener(this)
        binding.buttonPoint.setOnClickListener(this)
        binding.buttonEquals.setOnClickListener(this)
        binding.buttonSign.setOnClickListener(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[BasicKeyboardViewModel::class.java]
        binding = FragmentBasicKeyboardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onClick(v: View?) {
        val btnIndex = fromIdToIndex(v!!.id)

        val listener = activity as OnSelectedButtonListener?
        listener?.onButtonSelected(btnIndex)
    }

    private fun fromIdToIndex(id: Int): Int {
        var index = -1

        when (id) {
            binding.button0.id -> index = 0
            binding.button1.id -> index = 1
            binding.button2.id -> index = 2
            binding.button3.id -> index = 3
            binding.button4.id -> index = 4
            binding.button5.id -> index = 5
            binding.button6.id -> index = 6
            binding.button7.id -> index = 7
            binding.button8.id -> index = 8
            binding.button9.id -> index = 9
            binding.buttonPlus.id -> index = 10
            binding.buttonMinus.id -> index = 11
            binding.buttonMultiply.id -> index = 12
            binding.buttonDivide.id -> index = 13
            binding.buttonC.id -> index = 14
            binding.buttonDel.id -> index = 15
            binding.buttonPoint.id -> index = 16
            binding.buttonEquals.id -> index = 17
            binding.buttonSign.id -> index = 18
        }

        return index
    }
}