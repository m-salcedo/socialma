package com.msalcedo.socialma.home.base.di

import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.home.base.HomeActivity
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@HomeScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(activity: HomeActivity)
}