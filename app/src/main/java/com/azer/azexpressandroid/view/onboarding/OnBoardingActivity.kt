package com.azer.azexpressandroid.view.onboarding

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.navigation.fragment.NavHostFragment
import com.azer.azexpressandroid.R
import com.azer.azexpressandroid.base.BaseActivity
import com.azer.azexpressandroid.databinding.ActivityOnBoardingBinding
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_on_boarding

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        super.onCreate(savedInstanceState)
    }

    override fun bindView() {
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = frNavigatorOnBoarding as NavHostFragment
        val navController = navHostFragment.navController
        val navInflater = navController.navInflater
        val graph = navInflater.inflate(R.navigation.nav_auth)
//        val navArgument = NavArgument.Builder().setDefaultValue(isProfile).build()
//        graph.addArgument(
//            KEY_ARGUMENT,
//            navArgument
//        ) // This is where you pass the bundle data from Activity to StartDestination
        navHostFragment.navController.graph = graph
    }
}