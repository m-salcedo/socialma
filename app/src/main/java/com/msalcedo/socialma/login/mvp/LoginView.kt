package com.msalcedo.socialma.login.mvp

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.common.mvp.MVPView
import com.msalcedo.socialma.login.InstagramLoginActivity
import com.msalcedo.socialma.utils.StringHelper
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import com.twitter.sdk.android.core.identity.TwitterLoginButton
import io.reactivex.Observable
import kotlinx.android.synthetic.main.form_login.view.*
import java.lang.reflect.AccessibleObject.setAccessible

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SuppressLint("ViewConstructor")
class LoginView(override val activity: RxActivity) : MVPView(activity), LoginContract.View {

    override val loginTwitterObservable: Observable<TwitterSession> by lazy { getTwitterRx() }
    override val loginInstagramObservable: Observable<Any> by lazy { getInstagramRx() }


    private fun getTwitterRx(): Observable<TwitterSession> {

        return Observable.create { subscriber ->

            if (Application.component.twitterSession().authToken.secret != null) {
                TwitterCore.getInstance().sessionManager.clearActiveSession()
            }

            btnTwitter.callback = object : Callback<TwitterSession>() {
                override fun success(result: Result<TwitterSession>) {
                    subscriber.onNext(result.data)
                    Log.d("test", StringHelper().toString(result.data.userName))
                }

                override fun failure(exception: TwitterException) {
                    subscriber.onError(exception)
                    Log.e("test", StringHelper().toString(exception), exception)
                }

            }
        }
    }

    private fun getInstagramRx(): Observable<Any> {

        return RxView.clicks(btnInstagram)
    }

    override fun start(intent: Intent) {
        activity.startActivity(intent)
    }

    override fun startInstagram() {
        InstagramLoginActivity.start(activity)
    }

    override fun inflateLayout(container: ViewGroup?): View? = inflate(activity, R.layout.activity_login, this)
}

