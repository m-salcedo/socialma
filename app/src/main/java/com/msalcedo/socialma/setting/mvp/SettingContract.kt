package com.msalcedo.socialma.setting.mvp

import com.msalcedo.socialma.common.mvp.MVPContract
import io.reactivex.Observable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SettingContract {

    interface View: MVPContract.View {
        val logoutTwitterObservable: Observable<Any>
        val logoutInstagramObservable: Observable<Any>
        fun showTwitterButton(isLogin: Boolean)
        fun showInstagramButton(isLogin: Boolean)
    }

    interface Presenter: MVPContract.Presenter

    interface Model: MVPContract.Model {
        val isInstagramLogin: Boolean
        val isTwitterLogin: Boolean
        fun startLoginActivity()
        fun logoutInstagram()
        fun logoutTwitter()
    }
}