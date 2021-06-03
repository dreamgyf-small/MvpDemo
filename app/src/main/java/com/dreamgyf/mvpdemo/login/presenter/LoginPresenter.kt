package com.dreamgyf.mvpdemo.login.presenter

import com.dreamgyf.mvpdemo.base.BasePresenter
import com.dreamgyf.mvpdemo.login.model.LoginModel
import com.dreamgyf.mvpdemo.login.view.ILoginView

class LoginPresenter: BasePresenter<LoginModel, ILoginView>() {

    private val loginModel by lazy { getModel() }

    private val loginView by lazy { getView() }

    override fun setModel() = LoginModel(this)

    fun login(username: String, password: String) {
        loginModel!!.login(username,password)
    }

    fun onLoginSuccess() {
        mHandler!!.post(Runnable { loginView!!.onLoginSuccess() })
    }

    fun onLoginFailed() {
        mHandler!!.post(Runnable { loginView!!.onLoginFailed() })
    }
}