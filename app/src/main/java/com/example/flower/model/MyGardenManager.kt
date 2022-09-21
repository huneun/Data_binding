package com.example.flower.model

import android.content.Context
import io.reactivex.Single
import io.reactivex.rxjava3.core.Single

class MyGardenManager {

    companion object {
        private const val jsonFileName = "garden.json"
    }

    //    fun getMyGardenList(context: Context) : Observable<List<ViewData>> {
//        val jsonString = JsonManager().inputStream(context, jsonFileName)
//        return MyGardenItemTask(jsonString).run()
//        //스레드 독점?
//    }
    fun getMyGardenList2(context: Context): Single<List<ViewData>> {
        val jsonString = JsonManager().inputStream(context, jsonFileName)
        return MyGardenItemTask(jsonString).run2()
    }
}