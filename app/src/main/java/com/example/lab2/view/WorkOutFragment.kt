package com.example.lab2.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.adapter.TimersAdapter
import com.example.lab2.adapter.WorkOutAdapter
import com.example.lab2.viewmodel.WorksOutViewModel

class WorkOutFragment : Fragment() {
    private lateinit var viewModel: WorksOutViewModel

    private lateinit var workView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[WorksOutViewModel::class.java]
        viewModel.workout.observe(this, Observer {

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work_out, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workView = view.findViewById(R.id.worksView)
        workView.layoutManager = LinearLayoutManager(this.context)
        workView.adapter = WorkOutAdapter(viewModel.workout.value!!)
    }

}