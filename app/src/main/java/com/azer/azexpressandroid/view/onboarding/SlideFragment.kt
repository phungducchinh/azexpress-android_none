package com.azer.azexpressandroid.view.onboarding

import android.os.Bundle
import coil.api.load
import com.azer.azexpressandroid.R
import com.azer.azexpressandroid.base.BaseFragment
import com.azer.azexpressandroid.databinding.FragmentSlideBinding

class SlideFragment : BaseFragment<FragmentSlideBinding>() {

    companion object {
        private const val SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): SlideFragment {
            val fragment = SlideFragment()
            val args = Bundle()
            args.putInt(SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_slide

    override fun bindEvent() {
        val titles = resources.getStringArray(R.array.intro_title).toList()
        val description = resources.getStringArray(R.array.intro_subtitle).toList()
        val images = intArrayOf(
            R.drawable.bg_boarding_1,
            R.drawable.bg_boarding_2,
            R.drawable.bg_boarding_3
        )

        viewBinding.tvTitle.text = titles[arguments?.getInt(SECTION_NUMBER) ?: 0]
        viewBinding.tvDescription.text = description[arguments?.getInt(SECTION_NUMBER) ?: 0]
        viewBinding.ivImage.load(images[arguments?.getInt(SECTION_NUMBER) ?: 0])
    }
}