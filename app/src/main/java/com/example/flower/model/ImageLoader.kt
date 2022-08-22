package com.example.flower.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

object ImageLoader {

    fun loadImage(imageUrl: String):Bitmap? {
        var bmp: Bitmap? = null
        val connection: HttpURLConnection?
        try {
            val url = URL(imageUrl)
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 10000
            connection.doOutput = true
            connection.doInput = true
            connection.useCaches = true
            connection.connect()

            val resCode = connection.responseCode

            if(resCode == HttpURLConnection.HTTP_OK) {
                val input = connection.inputStream
                bmp = BitmapFactory.decodeStream(input)
                connection.disconnect()
            }
        }catch (e: MalformedURLException){
            e.printStackTrace()
        }catch (e: IOException) {
            e.printStackTrace()
        }

        return bmp
    }
}