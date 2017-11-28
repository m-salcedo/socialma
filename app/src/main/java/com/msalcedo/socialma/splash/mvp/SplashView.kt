package com.msalcedo.socialma.splash.mvp

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.common.mvp.MVPView

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SuppressLint("ViewConstructor")
class SplashView(override val activity: RxActivity): MVPView(activity), SplashContract.View {
    override fun inflateLayout(container: ViewGroup?): View? = inflate(activity, R.layout.activity_splash, this)
}