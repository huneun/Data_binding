package com.example.flower.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flower.databinding.RecyclerviewSecondItemBinding
import com.example.flower.model.ViewData

class PlantsAdapter(
    private val dataSet: ArrayList<ViewData>,
    private val onClickListener: (View, Int) -> Unit = { _, _ -> },
) : BaseAdapter(dataSet, onClickListener) {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

}
//    RecyclerView.Adapter<PlantsAdapter.ViewHolder>() {
//
////    private lateinit var itemClickListener : OnItemClickListener
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = RecyclerviewSecondItemBinding.inflate(
//            LayoutInflater.from(viewGroup.context),
//            viewGroup,
//            false
//        )
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
//        viewHolder.itemView.setOnClickListener {
//            onClickListener(it, position)
//        }
//        viewHolder.bind(dataSet[position])
//    }
//
//    override fun getItemCount(): Int {
//        Log.d("test-jennet", "PlantsAdapter ViewData ArrayList size : " + dataSet.size)
//        return dataSet.size
//    }
//
//
//}
