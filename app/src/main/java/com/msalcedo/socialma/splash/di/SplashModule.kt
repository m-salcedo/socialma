package com.msalcedo.socialma.splash.di

import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.splash.SplashActivity
import com.msalcedo.socialma.splash.mvp.SplashContract
import com.msalcedo.socialma.splash.mvp.SplashModel
import com.msalcedo.socialma.splash.mvp.SplashPresenter
import com.msalcedo.socialma.splash.mvp.SplashView
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class SplashModule(private val activity: SplashActivity) {

    @Provides
    @SplashScope
    fun provideSplashActivity(): SplashActivity = activity

    @Provides
    @SplashScope
    fun provideView(): SplashContract.View = SplashView(activity)

    @Provides
    @SplashScope
    fun providePresenter(
            view: SplashContract.View,
            model: SplashContract.Model): SplashContract.Presenter =
            SplashPresenter(view = view, model = model)

    @Provides
    @SplashScope
    fun provideModel(
            activity: SplashActivity,
            sessionManager: SessionManager): SplashContract.Model =
            SplashModel(activity = activity, sessionManager = sessionManager)
}