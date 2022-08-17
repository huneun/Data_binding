package com.example.flower.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flower.model.JsonManager

abstract class BaseFragment(private val jsonFileName : String) : Fragment() {

    lateinit var jsonString : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        try {
            jsonString = JsonManager().inputStream(context, jsonFileName)
            Log.d("test-jennet", "BaseFragment jsonString : ${jsonString}")
        }catch (e : ClassNotFoundException) {
            Log.e("test-jennet", "Exception to searching file in assets folder")
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}