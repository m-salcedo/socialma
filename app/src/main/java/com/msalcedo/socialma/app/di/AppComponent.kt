package com.msalcedo.socialma.app.di

import android.content.res.Resources
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.app.modules.MoshiModule
import com.msalcedo.socialma.app.modules.PicassoModule
import com.msalcedo.socialma.app.modules.TwitterModule
import com.msalcedo.socialma.app.modules.api.ApiModule
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.app.modules.api.UserApi
import com.msalcedo.socialma.common.storage.SessionManager
import com.squareup.moshi.Moshi
import com.squareup.picasso.Picasso
import com.twitter.sdk.android.core.TwitterSession
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@AppScope
@Component(modules = arrayOf(PicassoModule::class, MoshiModule::class, TwitterModule::class, ApiModule::class))
interface AppComponent {
    fun inject(app: Application): Unit
    fun picasso(): Picasso
    fun moshi(): Moshi
    fun resources(): Resources
    fun sessionManager(): SessionManager
    fun authApi(): UserApi
    fun twitterSession(): TwitterSession
    fun twitterApiClient(): MyTwitterApiClient
}