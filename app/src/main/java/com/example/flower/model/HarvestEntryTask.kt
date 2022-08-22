package com.example.flower.model

import android.util.Log
import com.example.flower.model.HarvestData
import com.example.flower.model.ViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class HarvestEntryTask(private val jsonString : String) {
    internal var arrayData = ArrayList<ViewData>()
    private val jObject = JSONObject(jsonString)
    internal val jArray = jObject.getJSONArray("result")

    val execute = CoroutineScope(Dispatchers.Main).launch {
        Log.d("test-jennet", "MyGardenItemTask")
        val havestList :ArrayList<HarvestData> = ArrayList()

        for(i in 0 until jArray.length()) {
            jArray.getJSONObject(i).let{

                val id = it.getString("id");
                val title = it.getString("name")
                val url = it.getString("url")
                val exp = it.getString("exp")
                val cycle = it.getString("cycle");
                val planted = it.getString("planted")
                val watered = it.getString("watered")
                val gardening = it.getString("gardening")?.let { it ->
                    when(it) {
                        "0" -> false
                        "1" -> true
                        else -> false
                    }
                }
                val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
                Log.d("test-jennet", "bitmap Image : $bitmapImage")
                var viewData = bitmapImage?.let { ViewData(it, title, planted, watered) }
                viewData?.let { it -> arrayData.add(it) }

                val harvestData = HarvestData(Integer.parseInt(id), title, url, exp, cycle, planted, watered,
                    gardening == true
                )
                havestList.add(harvestData)

            }

        }
        Log.d("test-jennet", "ArrayData : $arrayData")
    }

}