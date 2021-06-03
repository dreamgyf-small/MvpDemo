package com.dreamgyf.mvpdemo.login.view

import com.dreamgyf.mvpdemo.base.BaseView

interface ILoginView: BaseView {

    fun onLoginSuccess()

    fun onLoginFailed()
}