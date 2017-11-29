package com.msalcedo.socialma.home.instagram.di

import android.content.res.Resources
import com.msalcedo.socialma.app.modules.api.UserApi
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.home.instagram.InstagramFragment
import com.msalcedo.socialma.home.instagram.mvp.InstagramContract
import com.msalcedo.socialma.home.instagram.mvp.InstagramModel
import com.msalcedo.socialma.home.instagram.mvp.InstagramPresenter
import com.msalcedo.socialma.home.instagram.mvp.InstagramView
import com.squareup.moshi.Moshi
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class InstagramModule(val fragment: InstagramFragment) {

    @Provides
    @InstagramScope
    fun provideActivity(): HomeActivity = fragment.activity as HomeActivity

    @Provides
    @InstagramScope
    fun provideModel(
            moshi: Moshi,
            resources: Resources,
            userApi: UserApi,
            sessionManager: SessionManager,
            activity: HomeActivity
    ): InstagramContract.Model = InstagramModel(
            activity = activity,
            moshi = moshi,
            resources = resources,
            userApi = userApi,
            sessionManager = sessionManager
    )

    @Provides
    @InstagramScope
    fun provideView(
            activity: HomeActivity, picasso: Picasso): InstagramContract.View = InstagramView(activity = activity, uiListener = fragment, picasso = picasso)

    @Provides
    @InstagramScope
    fun providePresenter(
            view: InstagramContract.View,
            model: InstagramContract.Model
    ): InstagramContract.Presenter = InstagramPresenter(view = view, model = model)

}