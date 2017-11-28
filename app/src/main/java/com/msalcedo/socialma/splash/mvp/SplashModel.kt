package com.msalcedo.socialma.splash.mvp

import android.app.Activity
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.login.LoginActivity

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SplashModel(
        val activity: Activity,
        val sessionManager: SessionManager) : SplashContract.Model {

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
}