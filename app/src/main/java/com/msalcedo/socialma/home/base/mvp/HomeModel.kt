package com.msalcedo.socialma.home.base.mvp

import android.content.res.Resources
import android.text.TextUtils
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.home.base.mvp.HomeContract
import com.msalcedo.socialma.splash.SplashActivity
import com.squareup.moshi.Moshi
import com.twitter.sdk.android.core.TwitterSession

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class HomeModel(
        override val moshi: Moshi,
        override val resources: Resources,
        val activity: HomeActivity,
        val sessionManager: SessionManager
) : HomeContract.Model {

    override fun getUserName(): String {
        return sessionManager.userName
    }

    override fun getImage(): String {
        return sessionManager.avatar
    }

    override fun getFullname(): String {
        return sessionManager.fullname
    }

    override fun isTwitter(): Boolean {
        return sessionManager.userTwitter != null
    }

    override fun logout() {
        SplashActivity.start(activity)

        sessionManager.clear()
        SplashActivity.start(activity)
        activity.finish()
    }
}
