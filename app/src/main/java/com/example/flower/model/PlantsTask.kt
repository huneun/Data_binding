package com.example.flower.model

import android.util.Log
import com.example.flower.model.ViewData
import com.example.retrofitconnection.gson.RetrofitManager
import com.example.retrofitconnection.utils.RESPONSE_STATE
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class PlantsTask(private val search : String) {

    fun run() : Single<List<ViewData>>{
        RetrofitManager.instance.searchPhotos(searchTerm = search, completion = {
                responseState, value ->
            when(responseState) {
                RESPONSE_STATE.OKAY -> {
                    Log.d("test-jennet", "api connection success : $value")
                    value.let {
                        val body = it.asJsonObject
                        val results = body.getAsJsonArray("results")
                        val result  = results.get(0).asJsonObject
                        val createdDate = result.getAsJsonObject("created_at").asString
                        val updatedDate = result.getAsJsonObject("updated_at").asString
                        val description = result.getAsJsonObject("description").asString
                        val thumbNailUrl = result.getAsJsonObject("url").getAsJsonObject("thumb").asString
                        val likes = result.getAsJsonObject("likes").asInt
                        val name = search

                        val bitmapUrl = ImageLoader.loadImage(thumbNailUrl)
                        bitmapUrl?.let { mainImage -> HarvestData(itemName = name, itemImage = mainImage, itemDescription = description, itemLikes = likes, itemPlanted = createdDate, itemWatered = updatedDate) }
                    }
                }
                RESPONSE_STATE.FAIL -> {
                    Log.d("test-jennet", "api connection fail : $value")

                }
            }
        })


    }


}