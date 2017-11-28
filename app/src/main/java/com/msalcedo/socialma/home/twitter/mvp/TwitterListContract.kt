package com.msalcedo.socialma.home.twitter.mvp

import com.msalcedo.socialma.common.mvp.ErrorMessageFactory
import com.msalcedo.socialma.common.mvp.MVPContract
import com.msalcedo.socialma.common.storage.Auth
import com.twitter.sdk.android.core.TwitterSession
import com.twitter.sdk.android.tweetui.UserTimeline
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class TwitterListContract {
    interface Model: MVPContract.Model, ErrorMessageFactory {
        fun finish()
        fun getUserTimeLine(): UserTimeline
        fun isTwitter(): Boolean
        fun authTwitter(auth: Auth): Completable
        fun getTokenInsta(): String?
    }
    interface View: MVPContract.View {
        val loginTwitterObservable: Observable<TwitterSession>
        val uiListener: UI
        fun createAdapter(userTimeLine: UserTimeline)
        fun showEmptyLogin()
        fun hideEmptyLogin()

        interface UI {
            fun inflated()
        }

    }
    interface Presenter: MVPContract.Presenter {
        fun initView()
    }
}