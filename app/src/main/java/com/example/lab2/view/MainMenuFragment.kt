package com.example.lab2.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.DBWork
import com.example.lab2.R
import com.example.lab2.adapter.TimersAdapter
import com.example.lab2.model.Action
import com.example.lab2.viewmodel.MainMenuViewModel
import com.example.lab2.viewmodel.MainMenuViewModelFactory

class MainMenuFragment : Fragment() {
    private lateinit var viewModel: MainMenuViewModel
    private lateinit var timers: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timers = view.findViewById(R.id.timersView)
        timers.layoutManager = LinearLayoutManager(this.context)

        timers.adapter = TimersAdapter(viewModel.actionData.value!!)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MainMenuViewModelFactory(this.context))[MainMenuViewModel::class.java]



        viewModel.actionData.observe(this, Observer{

        })

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        DBWork.save(this.context, viewModel.actionData.value!!)
    }

}