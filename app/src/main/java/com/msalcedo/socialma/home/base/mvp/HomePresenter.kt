package com.msalcedo.socialma.home.base.mvp

import android.content.Intent
import com.msalcedo.socialma.R
import com.msalcedo.socialma.login.LoginActivity

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class HomePresenter(
        override val view: HomeContract.View,
        override val model: HomeContract.Model) : HomeContract.Presenter {

    private val TAG = "TAG_${HomePresenter::class.java.simpleName}"


    override fun onCreate() {
        view.setImage(model.getImage())
        view.setUsername(model.getUserName())
        view.setFullame(model.getFullname())

        if (model.isTwitter()) {
            view.mount(R.id.nav_twitter)
        } else {
            view.mount(R.id.nav_instagram)
        }
    }

    override fun onDestroy() {

    }

}