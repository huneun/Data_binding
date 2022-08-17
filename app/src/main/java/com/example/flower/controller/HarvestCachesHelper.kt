package com.example.flower.controller

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.flower.model.HarvestLocal

class HarvestCachesHelper(context: Context?, factory:SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper(context, HarvestLocal.DATABASE_NAME, factory, HarvestLocal.DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = "CREATE TABLE if not exists ${HarvestLocal.FenceEntry.TABLE_NAME}" +
                "(${HarvestLocal.FenceEntry.COLUMN_NAME} integer primary key autoincrement," +
                "${HarvestLocal.FenceEntry.COLUMN_URL} text, " +
                "${HarvestLocal.FenceEntry.COLUMN_EXP} text, " +
                "${HarvestLocal.FenceEntry.COLUMN_CYCLE} text, " +
                "${HarvestLocal.FenceEntry.COLUMN_PLANTED} integer," +
                "${HarvestLocal.FenceEntry.COLUMN_WATERED} integer, " +
                "${HarvestLocal.FenceEntry.COLUMN_GARDENING} text);"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE if exists ${HarvestLocal.FenceEntry.TABLE_NAME}")
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
}