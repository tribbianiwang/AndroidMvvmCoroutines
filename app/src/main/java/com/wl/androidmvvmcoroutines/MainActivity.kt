package com.wl.androidmvvmcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.wl.common.support.Constants
import com.wl.common.utils.LogUtils
import com.wl.common.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.logger.Level
import org.koin.core.logger.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        bt_login.setOnClickListener {

            ARouter.getInstance().build(Constants.PATH_LOGIN).navigation()


        }


    }
}