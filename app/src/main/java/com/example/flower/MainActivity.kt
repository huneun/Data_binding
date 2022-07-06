package com.example.flower

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.flower.databinding.ActivityMainBinding
import com.example.flower.view.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewpager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //메인엑티비티 바인딩
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        viewpager = activityMainBinding.vpLayout
        val tablayout = activityMainBinding.tablayoutMain

        tablayout.addOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.d("test-jennet", "onTabSelected tab : "+(p0?.position ?: -1))
                when(p0?.position ?: -1){
                    0-> viewpager.setCurrentItem(0, true)
                    1-> viewpager.setCurrentItem(1, true)
                    else -> -1
                }
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                Log.d("test-jennet", "onTabUnselected tab : "+ p0)
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
                Log.d("test-jennet", "onTabReselected tab : "+ p0)
            }

        })


        viewpager.adapter = ViewPagerAdapter(2, this)
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                tablayout.selectTab(tablayout.getTabAt(position))
                super.onPageSelected(position)
            }
        })


    }

}


