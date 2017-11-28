package com.msalcedo.socialma.app

import android.support.multidex.MultiDexApplication
import android.util.Log
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.app.di.AppModule
import com.msalcedo.socialma.app.di.DaggerAppComponent
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Application : MultiDexApplication() {

    private val TAG = "TAG_${Application::class.java.simpleName}"

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        val config = TwitterConfig.Builder(this)
                .logger(DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(TwitterAuthConfig(
                        getString(R.string.TWITTER_CONSUMER_KEY),
                        getString(R.string.TWITTER_CONSUMER_SECRET))
                ).debug(true)
                .build()

        Twitter.initialize(config)

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        component.inject(this)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build())
    }
}