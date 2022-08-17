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
import com.example.flower.controller.MyGardenItemTask
import kotlinx.coroutines.*

class FragmentMyGarden : BaseFragment("garden.json") {

    lateinit var gardenAdapter : HarvestAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentMygardenBinding.inflate(inflater, container, false)

        val task = MyGardenItemTask(jsonString)
        task.execute.invokeOnCompletion {
            when(it){
                is CancellationException -> Log.d("test-jennet", "MyGardenItemTask Thread Cancelled!!")
                else -> {
                    binding.rvMain.layoutManager = GridLayoutManager(context, 2)
                    gardenAdapter = HarvestAdapter(task.arrayData, onItemClickListener =
                    fun(view : View, position : Int) {
                        val nextIntent = Intent(activity, ItemActivity::class.java)
                        nextIntent.putExtra("pickup", task.jArray.getJSONObject(position).getString("name"))
                        startActivity(nextIntent)
                    } , binding)

                    binding.rvMain.adapter = gardenAdapter
                }
            }
        }

        return binding.root
    }
}