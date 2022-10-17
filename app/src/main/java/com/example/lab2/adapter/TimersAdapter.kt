package com.example.lab2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.model.Action

class TimersAdapter(private val list: MutableList<Action>) :
    RecyclerView.Adapter<TimersAdapter.TimerViewHolder>() {


    class TimerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var TV: TextView
        private var Edit: EditText
        private var Button: Button
        var index: TextView

        init {
            TV = itemView.findViewById(R.id.textView)
            index = itemView.findViewById(R.id.index)
            Edit = itemView.findViewById(R.id.edit)
            Button = itemView.findViewById(R.id.button)

            Button.setOnClickListener {
                TV.text = Edit.text
            }
        }

        fun bind(action: Action){
            //index.text = position.toString()

            Edit.setText(action.name)
            TV.text = action.time.toString()
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