package com.example.flower.model

import android.content.Context
import android.util.Log
import java.util.concurrent.CancellationException

class PlantManager {

    companion object {
        private const val jsonFileName = "plants.json" // 객체는 const X
    }

    fun getPlantsList(context: Context): List<ViewData> { //나중에 네트워크에서 데이터를 가져오는 로직으로 변경예정 getPlantsListfrom~

        val result = try {
            val jsonString = JsonManager().inputStream(context, jsonFileName)
            Log.d("test-jennet", "BaseFragment jsonString : $jsonString")
            PlantsTask(jsonString).let { task ->
                task.displayExecute.invokeOnCompletion { error ->
                    when (error) {
                        is CancellationException -> Log.d(
                            "test-jennet",
                            "PlantsTask Thread Cancelled!!"
                        )
                        else -> { task.arrayData
//                        binding.rvSecond.layoutManager = GridLayoutManager(context, 2)

//                        plantAdapter = HarvestAdapter(task.arrayData, onItemClickListener=
//                        fun(view : View, position : Int) {
//                            val nextIntent = Intent(activity, ItemActivity::class.java)
//                            nextIntent.putExtra("pickup", task.jArray.getJSONObject(position).getString("name"))
//                            startActivity(nextIntent)
//                        }, binding )
//                        binding.rvSecond.adapter = plantAdapter
                            //리턴 어떻게 할지?
                        }
                    }
                }
            }

        } catch (e: ClassNotFoundException) {
            Log.e("test-jennet", "Exception to searching file in assets folder")

        }

        return when(result){
            is List<*> -> {
                result as List<ViewData>
            }
            else -> emptyList()
        }
    }

}

