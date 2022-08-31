package com.example.flower.model

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.CancellationException

class MyGardenManager {

    companion object {
        private const val jsonFileName = "garden.json"
    }

    fun getMyGardenList(context: Context) : List<ViewData> {
        val jsonString = JsonManager().inputStream(context, jsonFileName)
        return MyGardenItemTask(jsonString).run().blockingSingle()
    }
}