package com.msalcedo.socialma.login.mvp

import android.content.res.Resources
import android.util.Log
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient.Companion.completableTwitterAuth
import com.msalcedo.socialma.app.modules.api.UserApi
import com.msalcedo.socialma.common.storage.Auth
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.login.LoginActivity
import com.msalcedo.socialma.utils.StringHelper
import com.squareup.moshi.Moshi
import io.reactivex.Completable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class LoginModel(
        val activity: LoginActivity,
        override val moshi: Moshi,
        val sessionManager: SessionManager,
        val userApi: UserApi,
        val myTwitterApiClient: MyTwitterApiClient,
        override val resources: Resources
) : LoginContract.Model {

    override fun startHomeActivity() {
        activity.finish()
        HomeActivity.start(activity)
    }

    override fun authInstagram(auth: Auth): Completable =
            userApi.self(auth.tokenInstagram!!)
                    .doOnSuccess {
                        sessionManager.auth = auth
                        sessionManager.userInstagram = it.data
                    }
                    .toCompletable()

    override fun authTwitter(auth: Auth): Completable =
            completableTwitterAuth(myTwitterApiClient, auth)
                    .doOnSuccess {
                        if (it.isSuccessful) {
                            sessionManager.auth = auth
                            sessionManager.userTwitter = it.body()
                        }
                    }
                    .toCompletable()



}

