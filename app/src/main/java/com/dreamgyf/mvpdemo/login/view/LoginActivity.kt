package com.dreamgyf.mvpdemo.login.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dreamgyf.mvpdemo.R
import com.dreamgyf.mvpdemo.base.BaseActivity
import com.dreamgyf.mvpdemo.base.BasePresenter
import com.dreamgyf.mvpdemo.base.BaseView
import com.dreamgyf.mvpdemo.login.model.LoginModel
import com.dreamgyf.mvpdemo.login.presenter.LoginPresenter

class LoginActivity : BaseActivity<LoginModel, ILoginView>(), ILoginView, View.OnClickListener {

    private val loginPresenter by lazy {getPresenter() as LoginPresenter}

    private var username: EditText? = null

    private var password: EditText? = null

    private var login: Button? = null

    private var clear: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        login!!.setOnClickListener(this)
        clear = findViewById(R.id.clear)
        clear!!.setOnClickListener(this)
    }

    override fun onLoginSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailed() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        Log.d("Click","Now Clicked")
        when(v!!.id) {
            R.id.login -> {
                var usernameStr = username!!.text.toString()
                var passwordStr = password!!.text.toString()
                loginPresenter!!.login(usernameStr,passwordStr)
            }
            R.id.clear -> {
                username!!.setText("")
                password!!.setText("")
            }
        }
    }

    override fun setPresenter() = LoginPresenter()
}