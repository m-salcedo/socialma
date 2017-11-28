package com.msalcedo.socialma.app.modules

import com.msalcedo.socialma.app.di.AppScope
import dagger.Module
import dagger.Provides
import com.msalcedo.socialma.app.di.AppModule
import com.msalcedo.socialma.app.modules.api.MyTwitterApiClient
import com.msalcedo.socialma.app.modules.network.NetworkModule
import com.twitter.sdk.android.core.*
import okhttp3.OkHttpClient


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module(includes = arrayOf(NetworkModule::class, AppModule::class))
class TwitterModule {

    @Provides
    @AppScope
    fun provideTwitterSession(): TwitterSession {
        var activeSession = TwitterCore.getInstance()
                .sessionManager.activeSession

        if (activeSession == null) {
            activeSession = TwitterSession(TwitterAuthToken(null,null), 0L, "")
        }

        return activeSession
    }

    @Provides
    @AppScope
    fun provideTwitterApiClient(activeSession: TwitterSession?, customClient: OkHttpClient): MyTwitterApiClient {

        var customApiClient: MyTwitterApiClient

        if (activeSession != null) {
            customApiClient = MyTwitterApiClient(activeSession, customClient)
            TwitterCore.getInstance().addApiClient(activeSession, customApiClient)
        } else {
            customApiClient = MyTwitterApiClient(customClient)
            TwitterCore.getInstance().addGuestApiClient(customApiClient)
        }

        return customApiClient
    }
}