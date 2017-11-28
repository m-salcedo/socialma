package com.msalcedo.socialma.home.twitter.mvp

import android.util.Log
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
class TwitterListPresenter(
        override val view: TwitterListContract.View,
        override val model: TwitterListContract.Model) : TwitterListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        compositeDisposable.add(view.loginTwitterObservable.subscribe({ twitterSession -> loginTwitter(twitterSession) }))
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    override fun initView() {
        if (model.isTwitter()) {
            view.createAdapter(model.getUserTimeLine())
            view.hideEmptyLogin()
        } else {
            view.showEmptyLogin()
        }
    }

    private fun loginTwitter(twitterSession: TwitterSession) {
        Log.d("TAG__", "antes de guardar")
        view.showProgress(R.string.loading)
        val auth = Auth(model.getTokenInsta(),
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


    private fun success() {
        view.hideProgress()
        initView()
    }

    private fun failed(it: Throwable) {
        view.showToast(model.getErrorMessage(it))
        view.hideProgress()
    }


}