package com.dreamgyf.mvpdemo.base

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<M: BaseModel, V: BaseView> : AppCompatActivity() {

    protected val mHandler = Handler()

    var mPresenter: BasePresenter<M,V>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(mPresenter == null)
            mPresenter = setPresenter()
        mPresenter!!.attach(mHandler,this as V)
    }

    abstract fun setPresenter(): BasePresenter<M,V>

    protected fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.detach()
    }
}
