package com.wl.androidmvvmcoroutines


class ProjectRepo{
    private lateinit var mService: ProjectApi

    init {
        mService = RetrofitManager.initRetrofit().getService(ProjectApi::class.java)
    }

    suspend fun loadProjectTree(): List<ProjectTree>? {
        return mService.loadProjectTree().data
    }
}