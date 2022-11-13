package com.example.lab2.ui.workouts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.adapter.WorkOutAdapter
import com.example.lab2.databinding.FragmentWorkOutBinding
import kotlinx.coroutines.runBlocking

class WorkOutFragment : Fragment() {
    private lateinit var viewModel: WorksOutViewModel
    private lateinit var binding: FragmentWorkOutBinding

    private lateinit var workView: RecyclerView
    private lateinit var add: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[WorksOutViewModel::class.java]

        binding = FragmentWorkOutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        workView = binding.worksView
        workView.layoutManager = LinearLayoutManager(this.context)

        add = binding.add
        add.setOnClickListener{
            runBlocking {
                viewModel.add()
            }

        }




        viewModel.workout.observe(viewLifecycleOwner, Observer {
            workView.adapter = WorkOutAdapter(viewModel.workout.value!!)
        })


    }
}