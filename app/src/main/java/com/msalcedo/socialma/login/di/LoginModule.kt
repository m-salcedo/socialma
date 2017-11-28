package com.msalcedo.socialma.login.di

import android.content.res.Resources
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.app.modules.api.UserApi
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.login.LoginActivity
import com.msalcedo.socialma.login.mvp.LoginContract
import com.msalcedo.socialma.login.mvp.LoginModel
import com.msalcedo.socialma.login.mvp.LoginPresenter
import com.msalcedo.socialma.login.mvp.LoginView
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class LoginModule(val activity: LoginActivity) {

    @Provides
    @LoginScope
    fun provideLoginActivity(): LoginActivity = activity

    @Provides
    @LoginScope
    fun provideView(): LoginContract.View = LoginView(activity)

    @Provides
    @LoginScope
    fun providePresenter(
            view: LoginContract.View,
            model: LoginContract.Model): LoginContract.Presenter =
            LoginPresenter(view, model)

    @Provides
    @LoginScope
    fun provideModel(
            activity: LoginActivity,
            moshi: Moshi,
            sessionManager: SessionManager,
            api: UserApi,
            myTwitterApiClient: MyTwitterApiClient,
            resources: Resources
    ): LoginContract.Model =
            LoginModel(
                    activity = activity,
                    moshi = moshi,
                    sessionManager = sessionManager,
                    userApi = api,
                    myTwitterApiClient = myTwitterApiClient,
                    resources = resources
            )

}