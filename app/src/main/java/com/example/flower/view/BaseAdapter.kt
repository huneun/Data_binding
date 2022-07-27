package com.example.flower.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flower.R
import com.example.flower.databinding.RecyclerviewSecondItemBinding
import com.example.flower.model.ViewData

abstract class BaseAdapter(
    private val dataSet: ArrayList<ViewData>,
    private val onClickListener: (View, Int) -> Unit = { _, _ -> },
) : RecyclerView.Adapter<MyViewHolder>() {

//    private lateinit var itemClickListener : OnItemClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerviewSecondItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            onClickListener(it, position)
        }
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        Log.d("test-jennet", "PlantsAdapter ViewData ArrayList size : " + dataSet.size)
        return dataSet.size
    }

    class ViewHolder(private val binding: RecyclerviewSecondItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ViewData) {
            binding.ivRecyclerview.setImageBitmap(data.itemImage)
            binding.tvRecycerview.text = data.itemName
            binding.ivRecyclerview.background =
                binding.root.resources.getDrawable(R.drawable.corners_diagonal_round, null)
            binding.ivRecyclerview.clipToOutline = true
        }

    }
}
