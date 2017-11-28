package com.msalcedo.socialma.home.instagram.di

import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.home.instagram.InstagramFragment
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@InstagramScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(InstagramModule::class))
interface InstagramComponent {
    fun inject(fragment: InstagramFragment)
}