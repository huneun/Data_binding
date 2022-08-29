package com.example.flower.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = HarvestLocal.FenceEntry.TABLE_NAME)
data class HarvestEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name: String="",
    var exp: String="",
    var url: String="",
    var cycle: String="",
    var planted: Int=0,
    var watered: Int=0,
    var gardening: String ="0"
    )