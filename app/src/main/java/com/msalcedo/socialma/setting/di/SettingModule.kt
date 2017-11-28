package com.msalcedo.socialma.setting.di

import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.setting.SettingActivity
import com.msalcedo.socialma.setting.mvp.SettingContract
import com.msalcedo.socialma.setting.mvp.SettingModel
import com.msalcedo.socialma.setting.mvp.SettingPresenter
import com.msalcedo.socialma.setting.mvp.SettingView
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class SettingModule(private val activity: SettingActivity) {

    @Provides
    @SettingScope
    fun provideSplashActivity(): SettingActivity = activity

    @Provides
    @SettingScope
    fun provideView(): SettingContract.View = SettingView(activity)

    @Provides
    @SettingScope
    fun providePresenter(
            view: SettingContract.View,
            model: SettingContract.Model): SettingContract.Presenter =
            SettingPresenter(view = view, model = model)

    @Provides
    @SettingScope
    fun provideModel(
            activity: SettingActivity,
            sessionManager: SessionManager): SettingContract.Model =
            SettingModel(activity = activity, sessionManager = sessionManager)
}