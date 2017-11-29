package com.msalcedo.socialma.app.modules

import com.msalcedo.socialma.app.di.AppScope
import com.msalcedo.socialma.app.di.FlatObjectsQualifier
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module
class MoshiModule {
    @Provides
    @AppScope
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @AppScope
    @FlatObjectsQualifier
    fun provideMoshiFlatObjects(): Moshi {
        return Moshi.Builder()
                .build()
    }
}