package com.example.flower.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.flower.R
import com.example.flower.databinding.FragmentMygardenBinding
import com.example.flower.databinding.FragmentPlantlistBinding
import com.example.flower.databinding.RecyclerviewMainItemBinding
import com.example.flower.databinding.RecyclerviewSecondItemBinding
import com.example.flower.model.ViewData

class HarvestAdapter(
    private val dataSet: ArrayList<ViewData>,
    private val onItemClickListener: (View, Int) -> Unit,
    private val viewBinding : ViewBinding
    ) : RecyclerView.Adapter<HarvestViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HarvestViewHolder {

        return when(viewBinding){
            is FragmentMygardenBinding ->
                MyGardenBindingView(RecyclerviewMainItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
            is FragmentPlantlistBinding ->
                PlantsBindingView(RecyclerviewSecondItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
            else ->
                MyGardenBindingView(RecyclerviewMainItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))

        }
    }

    override fun onBindViewHolder(viewHolder: HarvestViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            onItemClickListener(it, position)
        }
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() :Int {
        Log.d("test-jennet", "MyGarden ViewData ArrayList size : "+ dataSet.size)
        return dataSet.size
    }


}
