package com.example.flower.model

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.lang.Exception

class JsonManager {

    fun inputStream(context: Context?, json: String) : String{
        return context?.resources?.assets?.open(json)?.bufferedReader().use { it!!.readText() }
    }

    fun outputStream(writePath : String, json :String){
        try {
            File(writePath).bufferedWriter().use { it.write(json) }
        }catch (e : Exception) {
            Log.d("test-jennet","outputStream error : ${e.message}")
        }
    }

}