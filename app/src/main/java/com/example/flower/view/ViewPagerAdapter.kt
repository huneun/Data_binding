package com.example.flower.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.flower.view.FragmentMyGarden
import com.example.flower.view.FragmentPlants

private const val NUM_TABS = 2
private const val TAB_GARDEN = 0
private const val TAB_PLANTS = 1

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            TAB_GARDEN -> return FragmentMyGarden()
            TAB_PLANTS -> return FragmentPlants()
        }
        return FragmentMyGarden()
    }
}