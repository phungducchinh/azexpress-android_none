package com.azer.azexpressandroid.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.azer.azexpressandroid.R
import com.azer.azexpressandroid.view.MainActivity
import com.azer.azexpressandroid.view.onboarding.OnBoardingActivity
import com.jaeger.library.StatusBarUtil

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        super.onCreate(savedInstanceState)
        StatusBarUtil.setTranslucent(this)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }, 3000)
    }

}