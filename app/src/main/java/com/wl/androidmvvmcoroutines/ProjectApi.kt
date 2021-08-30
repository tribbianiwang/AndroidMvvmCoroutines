package com.wl.androidmvvmcoroutines

import retrofit2.http.GET

interface ProjectApi {
    @GET("project/tree/json")
    suspend fun loadProjectTree(): BaseResp<List<ProjectTree>>
}