package com.example.flower

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.flower.databinding.ActivityMainBinding
import com.example.flower.databinding.FragmentMygardenBinding
import com.example.flower.databinding.FragmentPlantlistBinding
import com.example.flower.view.FragmentMyGarden
import com.example.flower.view.FragmentPlants

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //메인엑티비티 바인딩
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.ivIconFlower.setOnClickListener {
            activityMainBinding.vMygardenPoint.setBackgroundResource(R.color.click_yellow)
            activityMainBinding.vPlantsPoint.setBackgroundResource(R.color.non_click_base)
            setFragment(0)
        }

        activityMainBinding.ivIconPlant.setOnClickListener {
            activityMainBinding.vMygardenPoint.setBackgroundResource(R.color.non_click_base)
            activityMainBinding.vPlantsPoint.setBackgroundResource(R.color.click_yellow)
            setFragment(1)
        }

        activityMainBinding.ivIconFlower.callOnClick()
    }

    private fun setFragment(fragNum : Int){
        val fragTrant = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                fragTrant.replace(activityMainBinding.layoutFragmentArea.id, FragmentPlants()).commit()
            }
            1 -> {
                fragTrant.replace(activityMainBinding.layoutFragmentArea.id, FragmentMyGarden()).commit()
            }
        }
    }

//    class RecyclerAsyncTask(val str : String, val arrayData : ArrayList<ViewData>) {
//
//        fun execute(binding : ViewBinding, context: Context) {
//            CoroutineScope(Dispatchers.Main).launch {
//                val jObject = JSONObject(str)
//                val jArray = jObject.getJSONArray("result")
//
//                for(i in 0 until jArray.length()) {
//                    val obj = jArray.getJSONObject(i)
//                    val url = obj.getString("url")
//                    val title = obj.getString("name")
//                    val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
//                    Log.d("test-jennet", "bitmap Image : "+bitmapImage)
//                    var viewData = bitmapImage?.let { ViewData(it, title) }!!
//                    viewData?.let { arrayData.add(it) }
//                }
//                Log.d("test-jennet", "ArrayData : "+ arrayData)
//                mActivityMainBinding.rvMain.layoutManager = GridLayoutManager(context, 2)
//                mActivityMainBinding.rvMain.adapter = CustomAdapter(arrayData)
//
//            }
//
//        }
//    }

}

