package com.wl.login

import androidx.lifecycle.viewModelScope
import com.fuusy.common.base.BaseViewModel
import com.fuusy.common.network.net.StateLiveData
import kotlinx.coroutines.launch

class LoginViewModel(private val repo : LoginRepo) : BaseViewModel() {
    val loginLiveData = StateLiveData<LoginResp>()
    val registerLiveData = StateLiveData<LoginResp>()

    fun login(userName: String, password: String) {

        viewModelScope.launch {
            repo.login(userName, password, loginLiveData)
        }

    }

    fun register(
        userName: String,
        password: String,
        rePassword: String,
    ) {
        viewModelScope.launch {
            repo.register(userName, password, rePassword, registerLiveData)
        }

    }

}