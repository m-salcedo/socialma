package com.msalcedo.socialma.home.twitter.mvp

import android.content.res.Resources
import android.util.Log
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient.Companion.completableTwitterAuth
import com.msalcedo.socialma.common.storage.Auth
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.utils.StringHelper
import com.squareup.moshi.Moshi
import com.twitter.sdk.android.tweetui.UserTimeline
import io.reactivex.Completable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class TwitterListModel(
        override val moshi: Moshi,
        override val resources: Resources,
        val activity: HomeActivity,
        val sessionManager: SessionManager,
        val myTwitterApiClient: MyTwitterApiClient
) : TwitterListContract.Model {

    var userTimeL: UserTimeline? = null

    override fun getTokenInsta(): String? {
        return sessionManager.auth!!.tokenInstagram
    }

    override fun getUserTimeLine(): UserTimeline {
        if (userTimeL != null) {
            userTimeL!!
        } else {
            userTimeL = UserTimeline.Builder()
                    .screenName(sessionManager.userTwitter!!.screenName)
                    .build()
        }

        return userTimeL!!
    }

    override fun isTwitter(): Boolean {
        return sessionManager.userTwitter != null
    }

    override fun authTwitter(auth: Auth): Completable =
            completableTwitterAuth(myTwitterApiClient, auth)
                    .doOnSuccess {
                        if (it.isSuccessful) {
                            sessionManager.auth = auth
                            sessionManager.userTwitter = it.body()
                        }
                    }
                    .toCompletable()


    override fun finish() {
        activity.finish()
    }

}