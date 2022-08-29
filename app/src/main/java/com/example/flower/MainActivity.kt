package com.example.flower

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.flower.databinding.ActivityMainBinding
import com.example.flower.model.HarvestDatabase
import com.example.flower.model.HarvestEntity
import com.example.flower.model.HarvestEntryTask
import com.example.flower.model.NetworkManager
import com.example.flower.view.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Job
import java.util.concurrent.CancellationException

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit private var menuSort : MenuItem
    lateinit var db : HarvestDatabase

    private val tabTitleArray = arrayOf(
        "MY GARDEN",
        "PLANT LIST"
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


        db = HarvestDatabase.getInstance(this)!!
        val apiConnect = NetworkManager()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val jsonString = apiConnect.sendGet(NetworkManager.PHOTOS)
            HarvestEntryTask(jsonString).let { task ->
                task.execute.invokeOnCompletion {
                    when(it) {
                        is CancellationException -> Log.d("test-jennet","MyGardenTask Thread Cancelled")
                        else -> task.entityList

                    }
                }

            }
        }


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



