package com.example.flower.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flower.R
import com.example.flower.databinding.RecyclerviewSecondItemBinding
import com.example.flower.model.ViewData

class PlantsAdapter(private val dataSet: ArrayList<ViewData>) :
    RecyclerView.Adapter<PlantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerviewSecondItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() :Int {
        Log.d("test-jennet", "PlantsAdapter ViewData ArrayList size : "+ dataSet.size)
        return dataSet.size
    }
    class ViewHolder(private val binding: RecyclerviewSecondItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ViewData) {
            binding.ivRecyclerview.setImageBitmap(data.itemImage)
            binding.tvRecycerview.text = data.itemName
            binding.ivRecyclerview.background = binding.root.resources.getDrawable(R.drawable.corners_diagonal_round, null)
            binding.ivRecyclerview.clipToOutline = true
        }

    }

}
