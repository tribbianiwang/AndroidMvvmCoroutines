package com.wl.androidmvvmcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var projectViewModel:ProjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        projectViewModel = ViewModelProviders.of(this).get(ProjectViewModel::class.java)

        projectViewModel.loadProjectTree()
        projectViewModel.mProjectTreeLiveData.observe(this,object: Observer<List<ProjectTree>>{
            override fun onChanged(t: List<ProjectTree>?) {
                tv_result.text = t.toString()
                Log.d(this.javaClass.simpleName,t.toString())

            }
        })
    }
}