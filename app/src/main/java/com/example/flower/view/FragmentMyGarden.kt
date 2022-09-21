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
        val arrayData = gardenManager.getMyGardenList2(requireContext())
         arrayData.subscribe { result ->
             binding.rvMain.layoutManager = GridLayoutManager(context, 2)
             gardenAdapter = HarvestAdapter(result, onItemClickListener =
              { _, position ->
                 val nextIntent = Intent(activity, ItemActivity::class.java)
                 nextIntent.putExtra("pickup", result[position].itemName)
                 startActivity(nextIntent)
              } , binding) //클릭리스너 람다표현 best

             binding.rvMain.adapter = gardenAdapter
             Log.d("test-jennet", "adapter : "+gardenAdapter);
         }

        return binding.root
    }
}