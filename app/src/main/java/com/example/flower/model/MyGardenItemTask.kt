package com.example.flower.model

import android.util.Log
import androidx.annotation.MainThread
import com.example.flower.model.ViewData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.from
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class MyGardenItemTask(private val jsonString : String) {
    internal var arrayData = ArrayList<ViewData>()
    private val jObject = JSONObject(jsonString)
    internal val jArray = jObject.getJSONArray("result")
    fun run() : Observable<List<ViewData>> {
        return Observable.create<List<ViewData>> {
            Log.d("test-jennet", "MyGardenItemTask")
            for(i in 0 until jArray.length()) {
                jArray.getJSONObject(i).let{
                    Log.d("test-jennet", "for scope")
                    val url = it.getString("url")
                    val title = it.getString("name")
                    val planted = it.getString("planted")
                    val watered = it.getString("watered")
                    val bitmapImage = ImageLoader.loadImage(url)
                    bitmapImage?.let { img ->
                        arrayData.add(ViewData(img ,title, planted,watered))
                    }

                }

            }
            Log.d("test-jennet", "ArrayData : $arrayData")
        }.subscribeOn(Schedulers.single()).observeOn(Schedulers.io())
    }

    fun run2() : Single<List<ViewData>> {
        return Single.create<List<ViewData>>{
            for(i in 0 until jArray.length()) {
                jArray.getJSONObject(i).let{
                    Log.d("test-jennet", "for scope")
                    val url = it.getString("url")
                    val title = it.getString("name")
                    val planted = it.getString("planted")
                    val watered = it.getString("watered")
                    val bitmapImage = ImageLoader.loadImage(url)
                    bitmapImage?.let { img ->
                        arrayData.add(ViewData(img ,title, planted,watered))
                    }

                }

            }
            Log.d("test-jennet", "ArrayData : $arrayData")
        }.subscribeOn(Schedulers.single()).observeOn(Schedulers.io())
    }

//     val execute = CoroutineScope(Dispatchers.Main).launch {
//         Log.d("test-jennet", "MyGardenItemTask")
//         for(i in 0 until jArray.length()) {
//              jArray.getJSONObject(i).let{
//                  val url = it.getString("url")
//                  val title = it.getString("name")
//                  val planted = it.getString("planted")
//                  val watered = it.getString("watered")
//                  val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
//                  Log.d("test-jennet", "bitmap Image : $bitmapImage")
//                  var viewData = bitmapImage?.let { ViewData(it, title, planted, watered) }
//                   viewData?.let { it -> arrayData.add(it) }
//              }
//
//         }
//         Log.d("test-jennet", "ArrayData : $arrayData")
//    }
}