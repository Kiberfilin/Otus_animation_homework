package com.example.otusanimationhomework

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import com.example.otusanimationhomework.databinding.FragmentExampleBinding
import com.example.otusanimationhomework.dto.AnimationExample

class MyExamplesRecyclerViewAdapter(
    private val values: Array<AnimationExample>,
    private val onClick: (AnimationExample) -> Unit
) : RecyclerView.Adapter<MyExamplesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = FragmentExampleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewHolder = ViewHolder(itemView)
        itemView.button.setOnClickListener {
            val item: AnimationExample = values[viewHolder.absoluteAdapterPosition]
            onClick(item)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.button.text = item.type
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentExampleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val button: Button = binding.button
    }

}