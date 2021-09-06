package com.wl.login
import com.wl.common.base.BaseRepository
import com.wl.common.network.RetrofitManager
import com.wl.common.network.net.StateLiveData

class LoginRepo( private val service: LoginApi) : BaseRepository() {

    suspend fun login(userName: String, password: String, stateLiveData: StateLiveData<LoginResp>) {
        executeResp({ service.login(userName, password) }, stateLiveData)
    }



}