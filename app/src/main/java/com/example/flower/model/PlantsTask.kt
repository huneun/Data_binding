package com.example.flower.model

import com.example.retrofitconnection.gson.RetrofitManager
import com.example.retrofitconnection.gson.SuccessResponseState
import io.reactivex.Single

class PlantsTask(private val search : String) {

    fun run() : Single<List<ViewData>> {
        return RetrofitManager.instance.searchPhotos(searchTerm = search)!!.map {
            when(it){
                is SuccessResponseState -> {
                    it.value?.map { harvestData -> harvestData.toViewData() }
                }else -> {
                    emptyList()
                }
            }
        }

    }


}