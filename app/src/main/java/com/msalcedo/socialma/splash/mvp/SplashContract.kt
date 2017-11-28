package com.msalcedo.socialma.splash.mvp

import com.msalcedo.socialma.common.mvp.MVPContract
import io.reactivex.Completable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SplashContract {

    interface View: MVPContract.View

    interface Presenter: MVPContract.Presenter

    interface Model: MVPContract.Model {
        val isLoggedIn: Boolean
        fun startHomeActivity()
        fun startLoginActivity()
    }
}