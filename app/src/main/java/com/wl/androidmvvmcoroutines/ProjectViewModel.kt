package com.wl.androidmvvmcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class ProjectViewModel() : ViewModel(){
    //LiveData
    private val mRepo = ProjectRepo()
    val mProjectTreeLiveData = MutableLiveData<List<ProjectTree>>()
    fun loadProjectTree() {

        viewModelScope.launch(Dispatchers.IO) {
            val data = mRepo.loadProjectTree()
            mProjectTreeLiveData.postValue(data)
        }
    }
}