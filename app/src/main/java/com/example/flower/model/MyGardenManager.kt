package com.example.flower.model

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import java.util.concurrent.CancellationException

class MyGardenManager {

    companion object {
        private const val jsonFileName = "garden.json"
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getMyGardenList(context: Context) : List<ViewData> {

        val result = try {
            val jsonString = JsonManager().inputStream(context, jsonFileName)
//            val jsonString = NetworkManager().sendGet(NetworkManager.PHOTOS)
            Log.d("test-jennet", "BaseFragment jsonString : $jsonString")
            MyGardenItemTask(jsonString).let { task->
                task.execute.invokeOnCompletion { error ->
                    when(error) {
                        is CancellationException -> Log.d("test-jennet","MyGardenTask Thread Cancelled")
                        else -> {
                            Log.d("test-jennet", "invokeOnCompletion arrayData")
                            task.arrayData
                        }
                    }
                }
            }
        }catch (e: ClassNotFoundException) {
            Log.e("test-jennet","Exception to searching file in assets folder")
        }

        return when(result) {
            is List<*> -> {
                Log.d("test-jennet", "Manager result List");
                result as List<ViewData>
            }
            else -> {
                Log.d("test-jennet", "Manager result emptyList");
                emptyList()
            }
        }
    }
}