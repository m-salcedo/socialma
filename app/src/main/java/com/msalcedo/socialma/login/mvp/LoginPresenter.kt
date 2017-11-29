package com.msalcedo.socialma.login.mvp

import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.storage.Auth
import com.twitter.sdk.android.core.TwitterSession
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class LoginPresenter(
        override val view: LoginContract.View,
        override val model: LoginContract.Model) : LoginContract.Presenter {

    private val TAG = "TAG_${LoginPresenter::class.java.simpleName}"
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        compositeDisposable.add(view.loginTwitterObservable.subscribe({ twitterSession -> loginTwitter(twitterSession) }))
        compositeDisposable.add(view.loginInstagramObservable.subscribe { loginInstagram() })
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    private fun loginInstagram() {
        view.startInstagram()
    }

    private fun loginTwitter(twitterSession: TwitterSession) {
        view.showProgress(R.string.loading)
        val auth = Auth(null,
                twitterSession.authToken.token,
                twitterSession.authToken.secret,
                twitterSession.userName,
                twitterSession.userId)
        val disposable = model.authTwitter(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ success() },
                        { failed(it) })
        compositeDisposable.add(disposable)
    }

    override fun setInstagramToken(accessToken: String?) {
        view.showProgress(R.string.loading)
        val auth = Auth(accessToken,
                null,
                null,
                null,
                null)
        val disposable = model.authInstagram(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ success() },
                        { failed(it) })
        compositeDisposable.add(disposable)
    }


    private fun success() {
        view.hideProgress()
        model.startHomeActivity()
    }

    private fun failed(it: Throwable) {
        view.showToast(model.getErrorMessage(it))
        view.hideProgress()
    }
}
