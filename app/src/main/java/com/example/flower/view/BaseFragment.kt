package com.example.flower.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.flower.model.ViewData

abstract class BaseFragment(private val jsonFileName : String) : Fragment() {

    lateinit var jsonString : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        try {
            val assetManager = resources.assets
            val inputStream = assetManager.open(jsonFileName)
            jsonString = inputStream.bufferedReader().use { it.readText() }
        }catch (e : ClassNotFoundException) {
            Log.e("test-jennet", "Exception to searching file in assets folder")
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}