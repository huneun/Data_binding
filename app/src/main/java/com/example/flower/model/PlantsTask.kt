package com.example.flower.model

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

class PlantsTask(private val search: String) {

    fun run(): Single<List<ViewData>> {
        return RetrofitManager.instance.searchPhotos(searchTerm = search).map {
            when (it) {
                is SuccessResponseState -> {
                    it.value.map { harvestData -> harvestData.toViewData() }
                }
                else -> {
                    emptyList()
                }
            }
        }
    }

//    viewModel.dataList.subscribe {
//        binding.adapter = it
//    }
//
//    onClickedListener() {
//        run()
//
//    }    }

//    var dataList: Observable<List<ViewData>> = Observable<List<ViewData>>()
//
//    fun run() {
//        RetrofitManager.instance.searchPhotos(searchTerm = search).subscribe {
//            when (it) {
//                is SuccessResponseState -> {
//                    dataList.value = it.value.map { harvestData -> harvestData.toViewData() }
//                }
//                else -> {
//                    dataList.value = emptyList()
//                }
//            }
//        }
//
//
//            completion = {
//                responseState, value ->
//            when(responseState) {
//                RESPONSE_STATE.OKAY -> {
//                    Log.d("test-jennet", "api connection success : $value")
//                    value.let {
//                        val body = it.asJsonObject
//                        val results = body.getAsJsonArray("results")
//                        val result  = results.get(0).asJsonObject
//                        val createdDate = result.getAsJsonObject("created_at").asString
//                        val updatedDate = result.getAsJsonObject("updated_at").asString
//                        val description = result.getAsJsonObject("description").asString
//                        val thumbNailUrl = result.getAsJsonObject("url").getAsJsonObject("thumb").asString
//                        val likes = result.getAsJsonObject("likes").asInt
//                        val name = search
//
//                        val bitmapUrl = ImageLoader.loadImage(thumbNailUrl)
//                        bitmapUrl?.let { mainImage -> HarvestData(itemName = name, itemImage = mainImage, itemDescription = description, itemLikes = likes, itemPlanted = createdDate, itemWatered = updatedDate) }
//                    }
//                }
//                RESPONSE_STATE.FAIL -> {
//                    Log.d("test-jennet", "api connection fail : $value")
//
//                }
//            }
//        })


    }