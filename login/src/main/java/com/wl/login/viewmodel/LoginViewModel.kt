package com.wl.login

import androidx.lifecycle.viewModelScope
import com.wl.common.base.BaseViewModel
import com.wl.common.network.net.StateLiveData
import kotlinx.coroutines.launch

class LoginViewModel(private val repo : LoginRepo) : BaseViewModel() {
    val loginLiveData = StateLiveData<LoginResp>()


    fun login(userName: String, password: String) {

        viewModelScope.launch {
            repo.login(userName, password, loginLiveData)
        }

    }



}