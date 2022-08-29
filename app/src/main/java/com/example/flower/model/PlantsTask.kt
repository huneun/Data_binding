package com.example.flower.model

import android.util.Log
import com.example.flower.model.ViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class PlantsTask(private val jsonString : String) {
     var arrayData = ArrayList<ViewData>()

    val displayExecute = CoroutineScope(Dispatchers.Main).launch {
        val jObject = JSONObject(jsonString)
        val jArray = jObject.getJSONArray("result")

        for(i in 0 until jArray.length()) {
            val obj = jArray.getJSONObject(i)
            val url = obj.getString("url")
            val title = obj.getString("name")
            val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
            Log.d("test-jennet", "bitmap Image : $bitmapImage")
            var viewData = bitmapImage?.let { ViewData(it, title,"","") }!!
            viewData?.let { arrayData.add(it) }
        }
        Log.d("test-jennet", "ArrayData : $arrayData")

    }

//    val addItemExecute = CoroutineScope(Dispatchers.Main).launch {
//        val jsonAddMyGarden = JSONObject()
//        jObject.put("","")
//    }



}