package com.msalcedo.socialma.setting.mvp

import android.content.DialogInterface
import com.msalcedo.socialma.R
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SettingPresenter(
        override val view: SettingContract.View,
        override val model: SettingContract.Model) : SettingContract.Presenter, DialogInterface.OnClickListener {

    private val compositeDisposable = CompositeDisposable()
    private var insta: Boolean = false

    override fun onCreate() {
        compositeDisposable.add(view.logoutTwitterObservable.subscribe { logoutTwitterConfitm() })
        compositeDisposable.add(view.logoutInstagramObservable.subscribe { logoutInstagramConfirm() })
        update()
    }

    private fun update() {
        view.showTwitterButton(model.isTwitterLogin)
        view.showInstagramButton(model.isInstagramLogin)
    }

    private fun logoutTwitterConfitm() {
        insta = false
        view.showConfirmation(R.string.tw__logout_btn_txt, R.string.tw_confirm_logout, this)
    }

    private fun logoutInstagramConfirm() {
        insta = true
        view.showConfirmation(R.string.ig__logout_btn_txt, R.string.ig_confirm_logout, this)
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
       if (insta) {
           logoutInstagram()
       } else {
           logoutTwitter()
       }
    }

    private fun logoutInstagram() {
        model.logoutInstagram()
       if (!model.isTwitterLogin) {
            model.startLoginActivity()
        } else {
            view.showToast(R.string.logout_instagram, false)
            update()
        }
    }

    private fun logoutTwitter() {
        model.logoutTwitter()
        if (!model.isInstagramLogin) {
            model.startLoginActivity()
        } else {
            view.showToast(R.string.logout_twitter, false)
            update()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }
}