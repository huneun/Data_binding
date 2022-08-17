package com.example.flower.controller

import android.util.Log
import com.example.flower.model.ViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class MyGardenItemTask(private val jsonString : String) {
    internal var arrayData = ArrayList<ViewData>()
    private val jObject = JSONObject(jsonString)
    internal val jArray = jObject.getJSONArray("result")

     val execute = CoroutineScope(Dispatchers.Main).launch {
         Log.d("test-jennet", "MyGardenItemTask")
         for(i in 0 until jArray.length()) {
              jArray.getJSONObject(i).let{
                  val url = it.getString("url")
                  val title = it.getString("name")
                  val planted = it.getString("planted")
                  val watered = it.getString("watered")
                  val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
                  Log.d("test-jennet", "bitmap Image : $bitmapImage")
                  var viewData = bitmapImage?.let { ViewData(it, title, planted, watered) }
                   viewData?.let { it -> arrayData.add(it) }
              }

         }
         Log.d("test-jennet", "ArrayData : $arrayData")
    }
}