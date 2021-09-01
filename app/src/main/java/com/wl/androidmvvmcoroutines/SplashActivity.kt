package com.wl.androidmvvmcoroutines

import android.content.Intent
import android.os.Bundle
import com.fuusy.common.base.BaseActivity
import com.wl.androidmvvmcoroutines.MainActivity
import com.wl.androidmvvmcoroutines.R
import com.wl.androidmvvmcoroutines.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun initData(savedInstanceState: Bundle?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getLayoutId(): Int = R.layout.activity_splash

}