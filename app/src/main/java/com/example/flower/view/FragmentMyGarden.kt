package com.example.flower.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flower.ItemActivity
import com.example.flower.databinding.FragmentMygardenBinding
import com.example.flower.model.MyGardenItemTask
import com.example.flower.model.MyGardenManager
import com.example.flower.model.PlantManager
import kotlinx.coroutines.*

class FragmentMyGarden : BaseFragment() {

    var gardenManager : MyGardenManager = MyGardenManager()
    lateinit var gardenAdapter : HarvestAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentMygardenBinding.inflate(inflater, container, false)
        val arrayData = gardenManager.getMyGardenList(requireContext())

        binding.rvMain.layoutManager = GridLayoutManager(context, 2)
        gardenAdapter = HarvestAdapter(arrayData, onItemClickListener =
        fun(view : View, position : Int) {
            val nextIntent = Intent(activity, ItemActivity::class.java)
            nextIntent.putExtra("pickup", arrayData[position].itemName)
            startActivity(nextIntent)
        } , binding)

        binding.rvMain.adapter = gardenAdapter

        return binding.root
    }
}