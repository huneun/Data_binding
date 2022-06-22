package com.example.flower.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flower.controller.ImageLoader
import com.example.flower.databinding.FragmentPlantlistBinding
import com.example.flower.model.ViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class FragmentPlants() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentPlantlistBinding.inflate(inflater, container, false)

        var arrayData = ArrayList<ViewData>()
        var jsonString : String? = null

        try {
            val assetManager = resources.assets
            val inputStream = assetManager.open("plants.json")
            jsonString = inputStream.bufferedReader().use { it.readText() }
        }catch (e : ClassNotFoundException) {
            Log.e("test-jennet", "Exception to searching file in assets folder")
        }

        CoroutineScope(Dispatchers.Main).launch {
            val jObject = JSONObject(jsonString)
            val jArray = jObject.getJSONArray("result")

            for(i in 0 until jArray.length()) {
                val obj = jArray.getJSONObject(i)
                val url = obj.getString("url")
                val title = obj.getString("name")
                val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
                Log.d("test-jennet", "bitmap Image : "+bitmapImage)
                var viewData = bitmapImage?.let { ViewData(it, title) }!!
                viewData?.let { arrayData.add(it) }
            }
            Log.d("test-jennet", "ArrayData : "+ arrayData)
            binding.rvSecond.layoutManager = GridLayoutManager(context, 2)
            binding.rvSecond.adapter = PlantsAdapter(arrayData)

        }
        return binding.root
    }
}