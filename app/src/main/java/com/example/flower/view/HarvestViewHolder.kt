package com.example.flower.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.flower.databinding.RecyclerviewMainItemBinding
import com.example.flower.model.ViewData

abstract class HarvestViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun bind(data : ViewData) {}
}