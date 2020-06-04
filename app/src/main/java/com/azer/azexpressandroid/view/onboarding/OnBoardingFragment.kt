package com.azer.azexpressandroid.view.onboarding

import androidx.viewpager.widget.ViewPager
import com.azer.azexpressandroid.R
import com.azer.azexpressandroid.base.BaseFragment
import com.azer.azexpressandroid.databinding.FragmentOnBoardingBinding
import com.azer.azexpressandroid.view.onboarding.adpter.ViewPagerAdapter

class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_on_boarding

    override fun bindEvent() {
        viewBinding.viewPager.adapter = ViewPagerAdapter(fragmentManager ?: return)
        viewBinding.tabLayout.setupWithViewPager(viewBinding.viewPager)
        viewBinding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
            }

        })
    }
}