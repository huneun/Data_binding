package com.example.flower.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flower.ItemActivity
import com.example.flower.controller.ImageLoader
import com.example.flower.databinding.FragmentMygardenBinding
import com.example.flower.model.ViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class FragmentMyGarden() : Fragment() {

    lateinit var gardenAdapter : MyGardenAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMygardenBinding.inflate(inflater, container, false)

        var arrayData = ArrayList<ViewData>()
        var jsonString : String? = null

        try {
            val assetManager = resources.assets
            val inputStream = assetManager.open("garden.json")
            jsonString = inputStream.bufferedReader().use { it.readText() }
        }catch (e : ClassNotFoundException) {
            Log.e("test-jennet", "Exception to searching file in assets folder")
        }

        CoroutineScope(Dispatchers.Main).launch {
            val jObject = JSONObject(jsonString)
            val jArray = jObject.getJSONArray("result")

            for(i in 0 until jArray.length()) {
                jArray.getJSONObject(i).let{
                    val url = it.getString("url")
                    val title = it.getString("name")
                    val planted = it.getString("planted")
                    val watered = it.getString("watered")
                    val bitmapImage = withContext(Dispatchers.IO) { ImageLoader.loadImage(url) }
                    Log.d("test-jennet", "bitmap Image : $bitmapImage")
                    var viewData = bitmapImage?.let { ViewData(it, title, planted, watered) }
                    viewData?.let { it -> arrayData.add(it) }

                }

            }
            Log.d("test-jennet", "ArrayData : $arrayData")
            binding.rvMain.layoutManager = GridLayoutManager(context, 2)
            gardenAdapter = MyGardenAdapter(arrayData)
            binding.rvMain.adapter = gardenAdapter

            gardenAdapter.setItemClickListener(object: MyGardenAdapter.OnItemClickListener {
                override fun onClick(v: View, position: Int) {

                    val nextIntent = Intent(activity, ItemActivity::class.java)
                    nextIntent.putExtra("pickup", jArray.getJSONObject(position).getString("name"))
                    startActivity(nextIntent)

                }
            })

        }
        return binding.root
    }
}