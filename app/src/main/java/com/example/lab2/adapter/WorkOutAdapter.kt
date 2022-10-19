package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.model.Workout

class WorkOutAdapter(private val list: MutableList<Workout>, ) :
    RecyclerView.Adapter<WorkOutAdapter.WorkOutHolder>() {


    class WorkOutHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView
        private val timeTextView: TextView
        private val countTextView: TextView
        private val complexityTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTextView)
            timeTextView = itemView.findViewById(R.id.timeTextView)
            countTextView = itemView.findViewById(R.id.countTextView)
            complexityTextView = itemView.findViewById(R.id.complexityTextView)


        }

        fun bind(workout: Workout) {
            nameTextView.text = workout.name
            timeTextView.text = workout.fullTime.toString()
            countTextView.text = workout.action.size.toString()
            complexityTextView.text = "5"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkOutHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_work_adapter, parent, false)
        return WorkOutHolder(view)
    }

    override fun onBindViewHolder(holder: WorkOutHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}