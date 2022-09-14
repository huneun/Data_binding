package com.example.flower.model

import android.content.Context
import android.util.Log
import java.util.concurrent.CancellationException

class PlantManager {

    companion object {
        private const val jsonFileName = "plants.json" // 객체는 const X
    }

    fun getPlantsList(context: Context): List<ViewData> { //나중에 네트워크에서 데이터를 가져오는 로직으로 변경예정 getPlantsListfrom~

        val jsonString = JsonManager().inputStream(context, jsonFileName)
        return PlantsTask(jsonString).run
    }

}

