package com.msalcedo.socialma.setting.mvp

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.common.mvp.MVPView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_setting.view.*

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SuppressLint("ViewConstructor")
class SettingView(override val activity: RxActivity) : MVPView(activity), SettingContract.View {

    override fun inflateLayout(container: ViewGroup?): View? = inflate(activity, R.layout.activity_setting, this)
    override val logoutInstagramObservable: Observable<Any> by lazy { logoutInstagram() }
    override val logoutTwitterObservable: Observable<Any> by lazy { logoutTwitter() }

    private fun logoutInstagram(): Observable<Any> {
        return RxView.clicks(llInstagramLogout)
    }

    private fun logoutTwitter(): Observable<Any> {
        return RxView.clicks(llTwitterLogout)
    }

    override fun showTwitterButton(isLogin: Boolean) {
        llTwitterLogout.isClickable = isLogin
    }

    override fun showInstagramButton(isLogin: Boolean) {
        llInstagramLogout.isClickable = isLogin
    }
}
