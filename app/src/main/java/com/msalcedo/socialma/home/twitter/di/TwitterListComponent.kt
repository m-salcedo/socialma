package com.msalcedo.socialma.home.twitter.di

import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.home.twitter.TwitterListFragment
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@TwitterListScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(TwitterListModule::class))
interface TwitterListComponent {
    fun inject(fragment: TwitterListFragment)
}