package com.example.flower.model

import android.graphics.Bitmap

data class HarvestData(
    val itemImage: Bitmap,
    val itemName: String,
    val itemLikes: Int,
    val itemDescription: String,
    val itemPlanted: String,
    val itemWatered: String
) {
    fun toViewData(): ViewData {
        return ViewData(itemImage, itemName, itemPlanted, itemWatered)
    }
}
