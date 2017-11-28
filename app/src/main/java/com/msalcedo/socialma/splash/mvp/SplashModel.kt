package com.msalcedo.socialma.splash.mvp

import android.app.Activity
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.app.modules.api.UserApi
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.login.LoginActivity
import io.reactivex.Completable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SplashModel(
        val activity: Activity,
        val sessionManager: SessionManager,
        val userApi: UserApi,
        val myTwitterApiClient: MyTwitterApiClient) : SplashContract.Model {

    override val isLoggedIn
        get() = sessionManager.isLoggedIn

    override fun startHomeActivity() {
        activity.finish()
        HomeActivity.start(activity)
    }

    override fun startLoginActivity() {
        sessionManager.clear()
        activity.finish()
        LoginActivity.start(activity)
    }

    override fun authInstagram(): Completable {
        return if (sessionManager.auth != null && sessionManager.auth!!.tokenInstagram != null) {
            userApi.self(sessionManager.auth!!.tokenInstagram!!)
                    .doOnSuccess {
                        sessionManager.userInstagram = it.data
                    }
                    .toCompletable()
        } else {
            Completable.complete()
        }
    }

    override fun authTwitter(): Completable {
        return if (sessionManager.auth != null && sessionManager.auth!!.tokenTwitter != null) {
            MyTwitterApiClient.completableTwitterAuth(myTwitterApiClient, sessionManager.auth!!)
                    .doOnSuccess {
                        if (it.isSuccessful) {
                            sessionManager.userTwitter = it.body()
                        }
                    }
                    .toCompletable()
        } else {
            Completable.complete()
        }
    }

}