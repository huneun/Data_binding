package com.example.flower.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flower.ItemActivity
import com.example.flower.databinding.FragmentPlantlistBinding
import com.example.flower.model.JsonManager
import com.example.flower.controller.PlantsTask
import kotlinx.coroutines.*
import org.json.JSONObject

class FragmentPlants : BaseFragment("plants.json") {

    lateinit var plantAdapter : HarvestAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentPlantlistBinding.inflate(inflater, container, false)

        PlantsTask(jsonString).let{ task ->
            task.displayExecute.invokeOnCompletion { error ->
                when(error) {
                    is CancellationException -> Log.d("test-jennet", "PlantsTask Thread Cancelled!!")
                    else -> {
                        binding.rvSecond.layoutManager = GridLayoutManager(context, 2)

                        plantAdapter = HarvestAdapter(task.arrayData, onItemClickListener=
                        fun(view : View, position : Int) {
                            val nextIntent = Intent(activity, ItemActivity::class.java)
                            nextIntent.putExtra("pickup", task.jArray.getJSONObject(position).getString("name"))
                            startActivity(nextIntent)
                        }, binding )
                        binding.rvSecond.adapter = plantAdapter
                    }
                }
            }
        }

        val writeJson = JSONObject()
        writeJson.put("test","write")
        JsonManager().outputStream("src/main/assets/plants2.txt",writeJson.toString())
        Log.d("test-jennet", "FragmentPlants jsonObject write")
        return binding.root
    }


}