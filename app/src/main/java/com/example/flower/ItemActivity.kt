package com.example.flower

import android.app.Activity
import android.graphics.Paint
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.view.Display
import android.widget.LinearLayout
import com.example.flower.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {
    lateinit var activityItemBinding: ActivityItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityItemBinding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(activityItemBinding.root)



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val metrix = windowManager.currentWindowMetrics
            val bounds: Rect = metrix.bounds
            val legacySize = Size(bounds.width(), bounds.height())
            activityItemBinding.contentScript.minimumHeight = legacySize.height - (legacySize.height/16)
            Log.d("test-jennet", "activityItemBinding.contentScript.minHeight : "+activityItemBinding.contentScript.minimumHeight)

        } else {
            val outMetrics = DisplayMetrics()
            val display: Display

            @Suppress("DEPRECATION")
            display = windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(outMetrics)
            val size = Point()
            @Suppress("DEPRECATION")
            display.getSize(size)
            @Suppress("DEPRECATION")
            activityItemBinding.contentScript.minHeight = display.height
        }



    }
}