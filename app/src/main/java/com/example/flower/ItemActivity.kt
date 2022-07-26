package com.example.flower

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.flower.databinding.ActivityItemBinding
import org.json.JSONArray
import org.json.JSONObject


class ItemActivity : AppCompatActivity() {
    lateinit var activityItemBinding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityItemBinding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(activityItemBinding.root)
        activityItemBinding.ivHome.setOnClickListener(clickListener)
        activityItemBinding.ivHome2.setOnClickListener(clickListener)
        activityItemBinding.ivShare.setOnClickListener(clickListener)
        activityItemBinding.ivShare2.setOnClickListener(clickListener)

        //인텐트로 getExtra로 가져올 뷰/ 스크립트 정보를 담은 키
        val plantKey = intent.getStringExtra("pickup");
        //json에서 파싱.
        var itemJSONObject : JSONObject
        var imageUrl : String = "https://url.kr/clakvg" //defaultUrl
        var scriptText : String = ""
        try {
            val itemStr = assets.open("plants.json").reader().readText();
            val itemROW = JSONObject(itemStr)
            val itemResult = itemROW.getString("result")
            val itemJSONArray = JSONArray(itemResult)
            for(i: Int in 0 until itemJSONArray.length()){
                itemJSONObject = itemJSONArray.getJSONObject(i)
                if(itemJSONObject.getString("name").equals(plantKey)){
                    imageUrl = itemJSONObject.getString("url")
                    scriptText = itemJSONObject.getString("exp")
                    break;
                }
            }
        }catch (e : ClassNotFoundException) {
            Log.d("test-jennet", "ClassNotFoundException : ${e.exception.message}")
        }
            //이미지뷰, 스크립트세팅
        Glide.with(this).load(imageUrl).into(activityItemBinding.ivItemView)
        activityItemBinding.tvItemScript.text = scriptText

    }

    private val clickListener = View.OnClickListener {
        when(it.id) {
            activityItemBinding.ivHome.id ,activityItemBinding.ivHome2.id -> onBackPressed()
            activityItemBinding.ivShare.id, activityItemBinding.ivShare2.id -> startActivity(Intent.createChooser(Intent(Intent.ACTION_SEND), "공유하기"))
        }
    }

}