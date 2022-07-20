package com.example.flower

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.flower.databinding.ActivityItemBinding


class ItemActivity : AppCompatActivity() {
    lateinit var activityItemBinding: ActivityItemBinding
    lateinit private var menuShare : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityItemBinding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(activityItemBinding.root)
//        var toolbar = activityItemBinding.titleBar.baseToolbar
//        toolbar.setBackgroundColor(Color.TRANSPARENT)
//        toolbar.setTitleTextColor(Color.DKGRAY)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)



//        supportActionBar?.setHomeAsUpIndicator(homeImg.drawable)

//        Log.d("test-jennet", "Menu : ${menu.hashCode()}")
//        menuInflater.inflate(R.menu.main_menu, menu)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            val metrix = windowManager.currentWindowMetrics
//            val bounds: Rect = metrix.bounds
//            val legacySize = Size(bounds.width(), bounds.height())
//            activityItemBinding.contentScript.minimumHeight = legacySize.height - (legacySize.height/16)
//            Log.d("test-jennet", "activityItemBinding.contentScript.minHeight : "+activityItemBinding.contentScript.minimumHeight)
//
//        } else {
//            val outMetrics = DisplayMetrics()
//            val display: Display
//
//            @Suppress("DEPRECATION")
//            display = windowManager.defaultDisplay
//            @Suppress("DEPRECATION")
//            display.getMetrics(outMetrics)
//            val size = Point()
//            @Suppress("DEPRECATION")
//            display.getSize(size)
//            @Suppress("DEPRECATION")
//            activityItemBinding.contentScript.minimumHeight = display.height
//        }
//




    }
//
//    override fun openOptionsMenu() {
//        Log.d("test-jennet", "openOptionsMenu ItemActivity")
//
//        super.openOptionsMenu()
//    }
//    override fun supportInvalidateOptionsMenu() {
//        Log.d("test-jennet", "supportInvalidateOptionsMenu ItemActivity")
//        super.supportInvalidateOptionsMenu()
//    }
//
//    override fun invalidateOptionsMenu() {
//        Log.d("test-jennet", "invalidateOptionsMenu ItemActivity")
//        super.invalidateOptionsMenu()
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        Log.d("test-jennet", "onPrepareOptionsMenu ItemActivity")
//        return super.onPrepareOptionsMenu(menu)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
////        super.onCreateOptionsMenu(menu)
//        menuInflater.inflate(R.menu.action_menu, menu)
////        menuBack = menu!!.findItem(R.id.item_top_navigater_back)
//        Log.d("test-jennet", "onCreateOptionsMenu ItemActivity")
//        menuShare = menu!!.findItem(R.id.item_top_navigater_share)
//
//        return true
//
//    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.action_menu, menu)
//
////        menuBack = menu!!.findItem(R.id.item_top_navigater_back)
//        Log.d("test-jennet", "onCreateOptionsMenu ItemActivity")
//        menuShare = menu!!.findItem(R.id.item_top_navigater_share)
//
//        return true
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
////            R.id.item_top_navigater_back -> {
////                Log.d("test-jennet", "onOptionsItemSelected app_bar: ${item.itemId} ")
////                true
////            }
//            R.id.item_top_navigater_share -> {
//                Log.d("test-jennet", "onOptionsItemSelected app_bar: ${item.itemId} ")
//                Log.d("test-jennet", "onOptionsItemSelected ItemActivity")
//
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}