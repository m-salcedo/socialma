package com.msalcedo.socialma.splash.mvp

import android.util.Log
import com.msalcedo.socialma.utils.StringHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import android.R.attr.delay
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SplashPresenter(
        override val view: SplashContract.View,
        override val model: SplashContract.Model) : SplashContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        if (model.isLoggedIn) {
            refreshData()
        } else {
            startLogin()
        }
    }

    private fun startLogin() {
        Observable.just(true).delay(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ model.startLoginActivity() })
    }

    private fun refreshData() {
        val disposable = model.authTwitter()
                .andThen(model.authInstagram())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    model.startHomeActivity()
                }, {
                    model.startLoginActivity()
                })
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}