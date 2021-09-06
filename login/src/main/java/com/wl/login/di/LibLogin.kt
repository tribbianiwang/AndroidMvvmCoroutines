package com.wl.login


import com.wl.common.network.RetrofitManager

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.logger.Logger
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module


val moduleLogin= module{
    single {
        RetrofitManager.initRetrofit().getService(LoginApi::class.java)
    }



    single {
        LoginRepo(get())
    }

    viewModel { LoginViewModel(get()) }
}