package com.example.flower.model

import android.graphics.Bitmap
import java.lang.Exception

data class HarvestData(
    val itemImage: Bitmap,
    val itemName: String,
    val itemLikes: Int,
    val itemDescription: String,
    val itemPlanted: String,
    val itemWatered: String)
