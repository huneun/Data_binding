package com.example.flower.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(HarvestEntity::class), version = 1)
abstract class HarvestDatabase :RoomDatabase(){
    abstract fun harvestDAO() : HarvestDAO

    companion object {
        var INSTANCE : HarvestDatabase? = null
        fun getInstance(context: Context) : HarvestDatabase? {
            if(INSTANCE == null) {
                synchronized(HarvestDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, HarvestDatabase::class.java, HarvestLocal.FenceEntry.TABLE_NAME)
                        .fallbackToDestructiveMigration() // 수정있을 때 새버전으로 새로 교체한다 (구버전을 드랍하고 새로 생성하는 방식)
                        .build()
                }
            }

            return INSTANCE
        }
    }
}