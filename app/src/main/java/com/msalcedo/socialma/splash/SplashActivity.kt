package com.msalcedo.socialma.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.splash.di.DaggerSplashComponent
import com.msalcedo.socialma.splash.di.SplashModule
import com.msalcedo.socialma.splash.mvp.SplashContract
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SplashActivity: RxActivity() {

    companion object {
        fun start(context: Context) {
            val intent = context.intentFor<SplashActivity>()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: SplashContract.Presenter
    @Inject
    lateinit var view: SplashContract.View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeComponent()
        setContentView(view.inflateLayout())
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun initializeComponent() {
        DaggerSplashComponent.builder()
                .splashModule(SplashModule(this))
                .appComponent(Application.component)
                .build()
                .inject(this)
    }
}