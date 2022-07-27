package com.example.flower.util

import android.util.Log
import com.example.flower.model.Item
import org.json.JSONArray
import org.json.JSONObject

//data class ParseResultParam(
//    val imageUrl: String,
//    val scriptText: String
//)

class JsonParser {
    companion object {
        fun parse(itemStr: String, plantKey: String): List<Item> {
            //json에서 파싱.
            var itemJSONObject: JSONObject
            val resultList: List<Item>

            try {
                val itemROW = JSONObject(itemStr)
                val itemResult = itemROW.getString("result")
                val itemJSONArray = JSONArray(itemResult)

                resultList = arrayListOf<Item>(itemJSONArray.length())
                var imageUrl: String = "https://url.kr/clakvg" //defaultUrl
                var scriptText: String = ""

                for (i: Int in 0 until itemJSONArray.length()) {
                    itemJSONObject = itemJSONArray.getJSONObject(i)
                    if (itemJSONObject.getString("name").equals(plantKey)) {
                        imageUrl = itemJSONObject.getString("url")
                        scriptText = itemJSONObject.getString("exp")
                        resultList.add(Item(imageUrl, scriptText))
                    }
                }
            } catch (e: ClassNotFoundException) {
                Log.d("test-jennet", "ClassNotFoundException : ${e.exception.message}")
            }

            return resultList
        }
    }
}