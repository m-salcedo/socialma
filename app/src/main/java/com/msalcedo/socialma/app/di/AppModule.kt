package com.msalcedo.socialma.app.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import com.msalcedo.socialma.app.Application

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class AppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApp(): Application = app

    @Provides
    @AppScope
    @AppQualifier
    fun provideApplicationContext(): Context = app

    @Provides
    @AppScope
    fun provideResources(): Resources = app.resources
}