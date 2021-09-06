package com.wl.login

import android.view.View
import android.webkit.WebChromeClient
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.kingja.loadsir.core.LoadSir
import com.wl.common.base.BaseVmActivity
import com.wl.common.loadsir.EmptyCallback
import com.wl.common.loadsir.ErrorCallback
import com.wl.common.loadsir.LoadingCallback
import com.wl.common.network.BaseResp
import com.wl.common.network.DataState
import com.wl.common.network.net.IStateObserver
import com.wl.common.support.Constants
import com.wl.common.support.Constants.Companion.KEY_LIVEDATA_BUS_LOGIN
import com.wl.common.support.Constants.Companion.SP_KEY_USER_INFO_NAME
import com.wl.common.support.LiveDataBus
import com.wl.common.utils.LogUtils
import com.wl.common.utils.SpUtils
import com.wl.login.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel


private const val TAG = "LoginActivity"

@Route(path = Constants.PATH_LOGIN)
class LoginActivity : BaseVmActivity<ActivityLoginBinding>() {

    private val mViewModel: LoginViewModel by viewModel()

    override fun initData() {
        initToolbar()
        initListener()
        registerObserve()

    }

    private fun initToolbar() {
        mBinding?.run {
            setToolbarBackIcon(llToolbarLogin.ivBack, R.drawable.ic_back_clear)
            setToolbarTitle(llToolbarLogin.tvTitle, "登录")
            llToolbarLogin.ivBack.setOnClickListener {
                finish()
            }
        }
    }

    private fun registerObserve() {





//        mViewModel.loginLiveData.observe(this, Observer {
//            LogUtils.d("stateldata","${it.dataState}")
//            if(it.dataState==DataState.STATE_LOADING){
//                showLoading()
//            }else{
//                dismissLoading()
//            }
//
//
//        })

        mViewModel.loginLiveData.observe(this,returnLoadingObserver())
        mViewModel.loginLiveData.observe(this, object : IStateObserver<LoginResp>(null) {



            override fun onDataChange(data: LoginResp?) {
                showToast("登录成功")
                SpUtils.put(SP_KEY_USER_INFO_NAME, data?.nickname)
                //DbHelper.insertUserInfo(this, it)
                LiveDataBus.get().with(KEY_LIVEDATA_BUS_LOGIN).postValue(data)
                LogUtils.d("keylivedata","${LiveDataBus.get().with(KEY_LIVEDATA_BUS_LOGIN).value.toString()}")
                finish()
            }

            override fun onReload(v: View?) {

            }





        })


    }

    private fun initListener() {
        mBinding?.run {
            tvToRegister.setOnClickListener {
                ARouter.getInstance().build(Constants.PATH_REGISTER)
                    .navigation()
            }

            btLogin.setOnClickListener {
                mViewModel.login(etUserName.text.toString(), etPassword.text.toString())
            }
        }


    }

    override fun getLayoutId(): Int = R.layout.activity_login


}
