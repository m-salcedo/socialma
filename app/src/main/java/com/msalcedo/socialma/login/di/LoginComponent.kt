package com.msalcedo.socialma.login.di

import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.login.LoginActivity
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(LoginModule::class))
@LoginScope
interface LoginComponent {
    fun inject(activity: LoginActivity)
}