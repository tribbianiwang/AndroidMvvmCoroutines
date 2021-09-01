package com.wl.login

import androidx.room.PrimaryKey

data class LoginResp(
    val admin: Boolean,
    val coinCount: Int,
    val email: String,
    val icon: String,
    @PrimaryKey
    val id: Int,
    val nickname: String,
    val password: String,
    val publicName: String,
    val token: String,
    val type: Int,
    val username: String
)