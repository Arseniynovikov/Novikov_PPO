package com.example.lr_3.second_keyboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.lr_3.R
import com.example.lr_3.databinding.FragmentSecondKeyboardBinding
import com.example.lr_3.input_output.OnSelectedButtonListener


class SecondKeyboardFragment : Fragment(), View.OnClickListener {


    private lateinit var viewModel: SecondKeyboardViewModel
    private lateinit var binding: FragmentSecondKeyboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonChange.setOnClickListener{
            it.findNavController().navigate(R.id.action_secondKeyboardFragment_to_basicKeyboardFragment)
        }

        binding.buttonOpen.setOnClickListener(this)
        binding.buttonClose.setOnClickListener(this)
        binding.buttonSin.setOnClickListener(this)
        binding.buttonCos.setOnClickListener(this)
        binding.buttonTan.setOnClickListener(this)
        binding.buttonCtn.setOnClickListener(this)
        binding.buttonLn.setOnClickListener(this)
        binding.buttonLog10.setOnClickListener(this)
        binding.buttonFact.setOnClickListener(this)
        binding.buttonSqrt.setOnClickListener(this)
        binding.buttonNumberInSecond.setOnClickListener(this)
        binding.buttonTwoInNumber.setOnClickListener(this)
        binding.buttonTenInNumber.setOnClickListener(this)
        binding.buttonC.setOnClickListener(this)
        binding.buttonExp.setOnClickListener(this)
        binding.buttonExpOut.setOnClickListener(this)
        binding.buttonPi.setOnClickListener(this)
        binding.buttonXIn3.setOnClickListener(this)
        binding.buttonOneDivideX.setOnClickListener(this)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[SecondKeyboardViewModel::class.java]
        binding = FragmentSecondKeyboardBinding.inflate(layoutInflater, container, false)
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
            binding.buttonOpen.id -> index = 19
            binding.buttonClose.id -> index = 20
            binding.buttonSin.id -> index = 21
            binding.buttonCos.id -> index = 22
            binding.buttonTan.id -> index = 23
            binding.buttonCtn.id -> index = 24
            binding.buttonLn.id -> index = 25
            binding.buttonLog10.id -> index = 26
            binding.buttonFact.id -> index = 27
            binding.buttonSqrt.id -> index = 28
            binding.buttonNumberInSecond.id -> index = 29
            binding.buttonTwoInNumber.id -> index = 30
            binding.buttonTenInNumber.id -> index = 31
            binding.buttonC.id -> index = 32
            binding.buttonExp.id -> index = 33
            binding.buttonExpOut.id -> index = 34
            binding.buttonPi.id -> index = 35
            binding.buttonXIn3.id -> index = 36
            binding.buttonOneDivideX.id -> index = 37

        }

        return index
    }


}