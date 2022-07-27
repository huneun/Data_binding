package com.example.flower.view

import androidx.recyclerview.widget.RecyclerView
import com.example.flower.R
import com.example.flower.databinding.RecyclerviewSecondItemBinding
import com.example.flower.model.ViewData

class MyViewHolder(private val binding: RecyclerviewSecondItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: ViewData) {
        binding.ivRecyclerview.setImageBitmap(data.itemImage)
        binding.tvRecycerview.text = data.itemName
        binding.ivRecyclerview.background =
            binding.root.resources.getDrawable(R.drawable.corners_diagonal_round, null)
        binding.ivRecyclerview.clipToOutline = true
    }

}