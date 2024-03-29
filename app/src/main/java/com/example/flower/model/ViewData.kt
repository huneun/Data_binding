package com.example.flower.model

import android.graphics.Bitmap
import android.widget.TextView

data class ViewData(
    val itemImage: Bitmap,
    val itemName: String,
    val itemPlanted: String,
    val itemWatered: String
    )