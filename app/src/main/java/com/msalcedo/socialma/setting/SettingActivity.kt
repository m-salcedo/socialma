package com.msalcedo.socialma.setting

import android.os.Bundle
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.setting.di.DaggerSettingComponent
import com.msalcedo.socialma.setting.di.SettingModule
import com.msalcedo.socialma.setting.mvp.SettingContract
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SettingActivity : RxActivity() {

    companion object {
        fun start(activity: RxActivity) {
            val intent = activity.intentFor<SettingActivity>()
            activity.startActivityForResult(intent, RESULT)
        }

        val RESULT: Int = 978
    }

    @Inject
    lateinit var presenter: SettingContract.Presenter
    @Inject
    lateinit var view: SettingContract.View

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
        DaggerSettingComponent.builder()
                .settingModule(SettingModule(this))
                .appComponent(Application.component)
                .build()
                .inject(this)
    }
}