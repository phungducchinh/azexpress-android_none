package com.azer.azexpressandroid.view.onboarding.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.azer.azexpressandroid.view.onboarding.SlideFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return SlideFragment.newInstance(position)
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "SLIDE 1"
            1 -> "SLIDE 2"
            2 -> "SLIDE 3"
            else -> null
        }
    }
}