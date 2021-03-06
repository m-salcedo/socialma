package com.msalcedo.socialma.splash.di

import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.splash.SplashActivity
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SplashScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SplashModule::class))
interface SplashComponent {
    fun inject(activity: SplashActivity): Unit
}