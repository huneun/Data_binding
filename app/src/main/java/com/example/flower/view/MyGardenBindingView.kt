package com.example.flower.view

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.flower.R
import com.example.flower.databinding.RecyclerviewMainItemBinding
import com.example.flower.model.ViewData

class MyGardenBindingView(private val binding: RecyclerviewMainItemBinding) : HarvestViewHolder(binding) {
    override fun bind(viewData : ViewData) {
        binding.ivRecyclerview.setImageBitmap(viewData.itemImage)
        binding.ivRecyclerview.background = binding.root.resources.getDrawable(R.drawable.corners_diagonal_round, null)
        binding.ivRecyclerview.clipToOutline = true
        binding.tvMainItemTitle.text = viewData.itemName
        binding.tvMainItemPlanted.text = viewData.itemPlanted
        binding.tvMainItemWatered.text = viewData.itemWatered
    }
}