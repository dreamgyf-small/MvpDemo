package com.dreamgyf.mvpdemo.base

import android.os.Handler

abstract class BasePresenter<M: BaseModel, V: BaseView>() {

    protected var mHandler: Handler? = null;

    private var model: M? = null

    private var view: V? = null

    fun attach(handler: Handler, view: V) {
        this.mHandler = handler
        this.view = view
        model = setModel()
    }

    fun detach() {
        this.view = null
        this.model = null
    }

    abstract fun setModel(): M

    protected fun getModel() = model

    protected fun getView() = view
}