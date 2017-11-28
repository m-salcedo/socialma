package com.msalcedo.socialma.login.mvp

import android.content.Intent
import com.msalcedo.socialma.common.mvp.ErrorMessageFactory
import com.msalcedo.socialma.common.mvp.MVPContract
import com.msalcedo.socialma.common.storage.Auth
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class LoginContract {

    interface View : MVPContract.View {
        val loginTwitterObservable: Observable<TwitterSession>
        val loginInstagramObservable: Observable<Any>
        fun start(intent: Intent)
        fun startInstagram()
    }

    interface Model : MVPContract.Model, ErrorMessageFactory {
        fun authInstagram(auth: Auth): Completable
        fun authTwitter(auth: Auth): Completable
        fun startHomeActivity()
    }

    interface Presenter : MVPContract.Presenter {
        fun setInstagramToken(accessToken: String?)
    }
}