package com.example.flower.model

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flower.ItemActivity
import com.example.flower.controller.ImageLoader
import com.example.flower.view.HarvestAdapter
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