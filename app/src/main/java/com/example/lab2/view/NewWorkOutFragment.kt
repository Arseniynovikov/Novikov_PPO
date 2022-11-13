package com.example.lab2.view

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.adapter.TimersAdapter
import com.example.lab2.viewmodel.NewWorkOutViewModel


class NewWorkOutFragment : Fragment() {
    private lateinit var viewModel: NewWorkOutViewModel
    private lateinit var timers: RecyclerView
    private lateinit var addButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timers = view.findViewById(R.id.timersView)
        timers.layoutManager = LinearLayoutManager(this.context)
        timers.adapter = TimersAdapter(viewModel.actionData.value!!)


        addButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener{
            viewModel.addElem()
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[NewWorkOutViewModel::class.java]
        viewModel.actionData.observe(this, Observer{
            timers.adapter = TimersAdapter(it!!)
        })



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_workout, container, false)
    }
}