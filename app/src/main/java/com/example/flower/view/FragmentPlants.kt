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
import com.example.flower.model.*
import kotlinx.coroutines.*
import org.json.JSONObject

class FragmentPlants : BaseFragment() {
    var plantManager : PlantManager = PlantManager()
    lateinit var plantAdapter : HarvestAdapter

    val searchList = arrayOf("apple", "sunflower", "grape")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentPlantlistBinding.inflate(inflater, container, false)
        val viewData = ArrayList<ViewData>();
        for(i in 0 until searchList.size-1) {
            val arrayData = plantManager.getPlantsList(searchList.get(i)).subscribe{ result ->
                viewData.add(result)
            }

        }


        binding.rvSecond.layoutManager = GridLayoutManager(context, 2)
        plantAdapter = HarvestAdapter(viewData, onItemClickListener=
            fun(view : View, position : Int) {
                val nextIntent = Intent(activity, ItemActivity::class.java)
                nextIntent.putExtra("pickup", viewData[position].itemName)
                startActivity(nextIntent)
            }, binding )
        binding.rvSecond.adapter = plantAdapter

//        val writeJson = JSONObject()
//        writeJson.put("test","write")
//        JsonManager().outputStream("src/main/assets/plants2.txt",writeJson.toString())
//        Log.d("test-jennet", "FragmentPlants jsonObject write")
        return binding.root
    }


}