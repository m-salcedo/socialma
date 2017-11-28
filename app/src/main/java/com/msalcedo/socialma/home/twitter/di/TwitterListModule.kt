package com.msalcedo.socialma.home.twitter.di

import android.content.res.Resources
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.home.twitter.TwitterListFragment
import com.msalcedo.socialma.home.twitter.mvp.TwitterListContract
import com.msalcedo.socialma.home.twitter.mvp.TwitterListModel
import com.msalcedo.socialma.home.twitter.mvp.TwitterListPresenter
import com.msalcedo.socialma.home.twitter.mvp.TwitterListView
import com.squareup.moshi.Moshi
import com.twitter.sdk.android.core.TwitterSession
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class TwitterListModule(private val fragment: TwitterListFragment) {

    @Provides
    @TwitterListScope
    fun provideActivity(): HomeActivity = fragment.activity as HomeActivity

    @Provides
    @TwitterListScope
    fun provideModel(
            moshi: Moshi,
            resources: Resources,
            myTwitterApiClient: MyTwitterApiClient,
            sessionManager: SessionManager,
            activity: HomeActivity
    ): TwitterListContract.Model = TwitterListModel(
            activity = activity,
            moshi = moshi,
            resources = resources,
            myTwitterApiClient = myTwitterApiClient,
            sessionManager = sessionManager
    )

    @Provides
    @TwitterListScope
    fun provideView(
            activity: HomeActivity): TwitterListContract.View = TwitterListView(activity = activity, uiListener = fragment)

    @Provides
    @TwitterListScope
    fun providePresenter(
            view: TwitterListContract.View,
            model: TwitterListContract.Model
    ): TwitterListContract.Presenter = TwitterListPresenter(view = view, model = model)

}