package com.example.flower

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.flower.databinding.ActivityMainBinding
import com.example.flower.view.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit private var menuSort : MenuItem

    private val tabTitleArray = arrayOf(
        "MY GARDEN",
        "PALNT LIST"
    )

    private val tabIconNonClickArray = arrayOf(
        R.drawable.flower,
        R.drawable.leaves
    )

    private val tabIconClickedArray = arrayOf(
        R.drawable.flower_click,
        R.drawable.leaves_click
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //메인엑티비티 바인딩
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setSupportActionBar(activityMainBinding.titleBar.baseToolbar)

        val viewPager = activityMainBinding.vpMain
        val tabLayout = activityMainBinding.tabBar.tablayoutMain

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
            tab.icon = getDrawable(tabIconNonClickArray[position])
        }.attach()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {

                tab?.position.let {
                    Log.d("test-jennet", "onTabSelected position : $it")
                    tab?.icon = getDrawable(tabIconClickedArray[it!!])
                    when(it) {
                        0 -> menuSort.setVisible(false)
                        1 -> menuSort.setVisible(true)
                        else -> menuSort.setVisible(false)
                    }
                }


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

                tab?.position.let{
                        Log.d("test-jennet", "onTabUnselected position : $it") // var pos
                        tab?.icon = getDrawable(tabIconNonClickArray[it!!])
                }

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("test-jennet", "Menu : ${menu.hashCode()}")
        menuInflater.inflate(R.menu.main_menu, menu)
        menuSort = menu!!.findItem(R.id.item_sort)
        Log.d("test-jennet", "onCreateOptionsMenu MainActivity ")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_sort -> {
                Log.d("test-jennet", "onOptionsItemSelected app_bar: $item ")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}



