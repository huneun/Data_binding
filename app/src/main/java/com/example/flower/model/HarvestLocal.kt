package com.example.flower.model

import android.provider.BaseColumns

object HarvestLocal {

    const val DATABASE_NAME = "harvest_db"
    const val DATABASE_VERSION = 1

    object FenceEntry : BaseColumns {
        const val TABLE_NAME = "table_fence"
        const val COLUMN_NAME = "name"
        const val COLUMN_URL = "url"
        const val COLUMN_EXP = "exp"
        const val COLUMN_CYCLE = "cycle"
        const val COLUMN_PLANTED = "planted"
        const val COLUMN_WATERED = "watered"
        const val COLUMN_GARDENING = "gardening"
    }

}