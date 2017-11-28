package com.msalcedo.socialma.home.base.di

import android.content.res.Resources
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.home.base.mvp.HomeContract
import com.msalcedo.socialma.home.base.mvp.HomeModel
import com.msalcedo.socialma.home.base.mvp.HomePresenter
import com.msalcedo.socialma.home.base.mvp.view.HomeView
import com.squareup.moshi.Moshi
import com.squareup.picasso.Picasso
import com.twitter.sdk.android.core.TwitterSession
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class HomeModule(val activity: HomeActivity) {

    @Provides
    @HomeScope
    fun provideActivity(): HomeActivity = activity

    @Provides
    @HomeScope
    fun provideModel(
            sessionManager: SessionManager,
            activity: HomeActivity,
            moshi: Moshi,
            resources: Resources
    ): HomeContract.Model = HomeModel(
            sessionManager = sessionManager,
            activity = activity,
            moshi = moshi,
            resources = resources)

    @Provides
    @HomeScope
    fun provideView(
            picasso: Picasso
    ): HomeContract.View = HomeView(
            activity = activity,
            picasso = picasso,
            drawerListener = activity)

    @Provides
    @HomeScope
    fun providePresenter(
            view: HomeContract.View,
            model: HomeContract.Model
    ): HomeContract.Presenter = HomePresenter(view = view, model = model)
}