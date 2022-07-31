package com.example.flower.view

import androidx.viewbinding.ViewBinding
import com.example.flower.R
import com.example.flower.databinding.RecyclerviewSecondItemBinding
import com.example.flower.model.ViewData

class PlantsBindingView(private val binding: RecyclerviewSecondItemBinding) : HarvestViewHolder(binding) {
    override fun bind(data: ViewData) {
        binding.ivRecyclerview.setImageBitmap(data.itemImage)
        binding.tvRecycerview.text = data.itemName
        binding.ivRecyclerview.background = binding.root.resources.getDrawable(R.drawable.corners_diagonal_round, null)
        binding.ivRecyclerview.clipToOutline = true
    }
}