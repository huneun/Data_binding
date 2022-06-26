package com.example.flower.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(val pageNumber: Int, fragmentActivity : FragmentActivity) : FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return pageNumber
    }

    override fun createFragment(position: Int) : Fragment {
        return when(position){
            0 -> {
                FragmentMyGarden()
            }
            else ->{
                FragmentPlants()

            }
        }
    }

}