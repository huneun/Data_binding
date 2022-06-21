package com.example.flower.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
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
            binding.tvRecycerview.text = data.itemText
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
