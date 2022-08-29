package com.example.flower.model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class NetworkManager {

    companion object {
        const val PHOTOS = "photos/"
        const val COLLECTIONS = "collections/"
        private const val HOST = "https://api.unsplash.com/"
        private const val USER = "users/huneun/"
        private const val ACCESS_KEY  = "?client_id=2kPRCHud1L3_YS_-66YWVLg-Q_uBeHhx7bnThxfEohU"
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun sendGet(param : String) : String{
        val url = URL(HOST+ USER+ param+ ACCESS_KEY)
        return url.readText()
    }

}