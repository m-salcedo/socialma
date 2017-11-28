package com.msalcedo.socialma.app.modules.api


import dagger.Module
import dagger.Provides
import com.msalcedo.socialma.app.di.AppScope
import com.msalcedo.socialma.app.modules.network.RetrofitModule
import retrofit2.Retrofit

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {

    @Provides
    @AppScope
    fun provideAuthApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

}