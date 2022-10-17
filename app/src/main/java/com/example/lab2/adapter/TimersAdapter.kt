package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.model.Action

class TimersAdapter(private val list: MutableList<Action>, ) :
    RecyclerView.Adapter<TimersAdapter.TimerViewHolder>() {


    class TimerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameText: TextView
        private var timeEdit: EditText
        private var plusButton: Button
        private var minusButton: Button

        init {
            nameText = itemView.findViewById(R.id.nameEdit)
            timeEdit = itemView.findViewById(R.id.timeEdit)
            plusButton = itemView.findViewById(R.id.plusButton)
            minusButton = itemView.findViewById(R.id.minusButton)

        }

        fun bind(action: Action) {
            nameText.text = action.name
            timeEdit.setText(action.time.toString())

            plusButton.setOnClickListener {
                action.time += 1
                timeEdit.setText(action.time.toString())

            }

            minusButton.setOnClickListener {
                if (action.time > 0) {
                    action.time -= 1
                    timeEdit.setText(action.time.toString())

                }

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_main_adapter, parent, false)
        return TimerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


}