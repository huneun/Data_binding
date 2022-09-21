package com.example.flower.model

import android.graphics.Bitmap

data class ViewData(
    val itemImage: Bitmap,
    val itemName: String,
    val itemPlanted: String,
    val itemWatered: String
)