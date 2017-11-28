package com.msalcedo.socialma.splash.mvp

import android.util.Log
import com.msalcedo.socialma.app.Application
import io.reactivex.disposables.CompositeDisposable

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
            Log.d("TAG__", "session iniciada  " + Application.component.sessionManager().auth)


            model.startHomeActivity()
        } else {
            Log.d("TAG__", "session cerrada " + Application.component.sessionManager().auth)
            model.startLoginActivity()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}