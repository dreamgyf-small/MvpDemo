package com.dreamgyf.mvpdemo.login.model

import com.dreamgyf.mvpdemo.base.BaseModel
import com.dreamgyf.mvpdemo.login.presenter.LoginPresenter

class LoginModel: BaseModel {

    private var loginPresenter: LoginPresenter? = null

    constructor(loginPresenter: LoginPresenter) {
        this.loginPresenter = loginPresenter
    }

    fun login(username: String, password: String) {
        Thread(Runnable {
            Thread.sleep(3000) //假设网络3秒
            if(username.equals("admin") && password.equals("admin"))
                loginPresenter!!.onLoginSuccess()
            else
                loginPresenter!!.onLoginFailed()
        }).start()
    }
}