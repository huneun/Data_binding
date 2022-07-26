package com.example.flower.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flower.R
import com.example.flower.databinding.RecyclerviewMainItemBinding
import com.example.flower.model.ViewData

class MyGardenAdapter(private val dataSet: ArrayList<ViewData>) :
    RecyclerView.Adapter<MyGardenAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerviewMainItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() :Int {
        Log.d("test-jennet", "MyGarden ViewData ArrayList size : "+ dataSet.size)
        return dataSet.size
    }
    class ViewHolder(private val binding: RecyclerviewMainItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ViewData) {
            binding.ivRecyclerview.setImageBitmap(data.itemImage)
            binding.ivRecyclerview.background = binding.root.resources.getDrawable(R.drawable.corners_diagonal_round, null)
            binding.ivRecyclerview.clipToOutline = true
            binding.tvMainItemTitle.text = data.itemName
            binding.tvMainItemPlanted.text = data.itemPlanted
            binding.tvMainItemWatered.text = data.itemWatered

        }

    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener
}
