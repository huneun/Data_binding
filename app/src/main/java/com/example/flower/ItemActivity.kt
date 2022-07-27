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
import com.example.flower.util.JsonParser


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
        val plantKey = intent.getStringExtra(Constants.KEY_PICK_UP) ?: ""
        val res = JsonParser.parse(assets.open("plants.json").reader().readText(), plantKey)
            //이미지뷰, 스크립트세팅
        Glide.with(this).load(res.imageUrl).into(activityItemBinding.ivItemView)
        activityItemBinding.tvItemScript.text = res.scriptText

    }

    private val clickListener = View.OnClickListener {
        when(it.id) {
            activityItemBinding.ivHome.id ,activityItemBinding.ivHome2.id -> onBackPressed()
            activityItemBinding.ivShare.id, activityItemBinding.ivShare2.id -> startActivity(Intent.createChooser(Intent(Intent.ACTION_SEND), "공유하기"))
        }
    }

}