package com.msalcedo.socialma.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.login.InstagramLoginActivity.Companion.INSTAGRAM_LOGIN
import com.msalcedo.socialma.login.di.DaggerLoginComponent
import com.msalcedo.socialma.login.di.LoginModule
import com.msalcedo.socialma.login.mvp.LoginContract
import com.msalcedo.socialma.utils.Constant
import kotlinx.android.synthetic.main.form_login.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class LoginActivity : RxActivity() {

    companion object {
        fun start(context: Context) {
            val intent = context.intentFor<LoginActivity>()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    @Inject lateinit var presenter: LoginContract.Presenter
    @Inject lateinit var view: LoginContract.View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_enter_bottom, R.anim.no_anim)
        initializeComponent()
        setContentView(view.inflateLayout())
        presenter.onCreate()
        animate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun initializeComponent() {
        DaggerLoginComponent.builder()
                .appComponent(Application.component)
                .loginModule(LoginModule(this))
                .build()
                .inject(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        btnTwitter.onActivityResult(requestCode, resultCode, data)

        if (requestCode == INSTAGRAM_LOGIN) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val accessToken = data!!.getStringExtra(Constant.Key.ACCESS_TOKEN)
                    presenter.setInstagramToken(accessToken)
                }
                Activity.RESULT_CANCELED -> {

                }
                else -> {

                }
            }
        }
    }

    private fun animate() {
        val scale = AlphaAnimation(0f, 1f)
        scale.fillAfter = true
        scale.duration = 1500
        llLogin.startAnimation(scale)
    }
}
