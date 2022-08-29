package com.example.flower.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface HarvestDAO {
    @Insert(onConflict = REPLACE)
    fun insert(harvest: HarvestEntity)

    @Query("SELECT * FROM ${HarvestLocal.FenceEntry.TABLE_NAME}")
    fun getAll() : List<HarvestEntity>

    @Delete
    fun delete(harvest : HarvestEntity)
}