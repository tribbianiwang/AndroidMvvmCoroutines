package com.wl.androidmvvmcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.fuusy.common.support.Constants
import com.fuusy.common.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_login.setOnClickListener {
//            Toast.makeText(this,"startlogin",Toast.LENGTH_SHORT).show()
            ARouter.getInstance().build(Constants.PATH_LOGIN).navigation()
        }


    }
}