package com.wl.androidmvvmcoroutines

import android.app.Application
import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.paging.ExperimentalPagingApi
import com.alibaba.android.arouter.launcher.ARouter
import com.wl.common.loadsir.EmptyCallback
import com.wl.common.loadsir.ErrorCallback
import com.wl.common.loadsir.LoadingCallback
import com.wl.common.utils.AppHelper
import com.kingja.loadsir.core.LoadSir
import com.wl.login.moduleLogin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.logger.Logger


@ExperimentalPagingApi
class MainApp : Application() {

    companion object {
        lateinit  var instance: MainApp
    }


    private val modules = arrayListOf(
        moduleLogin
    )

    override fun onCreate() {
        super.onCreate()
        initARouter()
        initLoadSir()
        initKoin()
        AppHelper.init(this.applicationContext)
        instance = this
    }

    //koin
    private fun initKoin() {
        startKoin {


            androidLogger()
            androidContext(this@MainApp)
            modules(modules)
        }
    }


    private fun initLoadSir() {
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(LoadingCallback())
            .addCallback(EmptyCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
    }

    private fun initARouter() {
        ARouter.init(this)
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}