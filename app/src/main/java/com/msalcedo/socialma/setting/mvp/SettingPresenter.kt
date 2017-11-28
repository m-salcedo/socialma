package com.msalcedo.socialma.setting.mvp

import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SettingPresenter(
        override val view: SettingContract.View,
        override val model: SettingContract.Model) : SettingContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        compositeDisposable.add(view.logoutTwitterObservable.subscribe { logoutTwitter() })
        compositeDisposable.add(view.logoutInstagramObservable.subscribe { logoutInstagram() })

        update()
    }

    private fun update() {
        view.showTwitterButton(model.isTwitterLogin)
        view.showInstagramButton(model.isInstagramLogin)
    }

    private fun logoutInstagram() {
        model.logoutInstagram()
        if (!model.isTwitterLogin) {
            model.startLoginActivity()
        } else {
            update()
        }
    }

    private fun logoutTwitter() {
        model.logoutTwitter()
        if (!model.isInstagramLogin) {
            model.startLoginActivity()
        } else {
            update()

        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}