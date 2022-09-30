package com.example.flower.model

import android.content.Context
import android.util.Log
import io.reactivex.Single
import java.util.concurrent.CancellationException

class PlantManager {

    fun getPlantsList(search: String): Single<ViewData> { //나중에 네트워크에서 데이터를 가져오는 로직으로 변경예정 getPlantsListfrom~
//        val jsonString = JsonManager().inputStream(context, jsonFileName)

        return PlantsTask(search).run().map { it ->
            it.get(it.size-1)
        }

    }

}

