package com.example.lab2.ui.workouts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.adapter.WorkOutAdapter
import com.example.lab2.databinding.FragmentWorkOutBinding
import com.example.lab2.model.Workout
import kotlinx.coroutines.runBlocking

class WorkOutFragment : Fragment() {
    private lateinit var viewModel: WorksOutViewModel
    private lateinit var binding: FragmentWorkOutBinding

    private lateinit var workView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[WorksOutViewModel::class.java]

//        runBlocking {
//            viewModel.add()
//        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkOutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        workView = binding.worksView
        workView.layoutManager = LinearLayoutManager(this.context)



    }
}