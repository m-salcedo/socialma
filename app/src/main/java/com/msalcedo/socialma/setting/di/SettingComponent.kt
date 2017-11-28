package com.msalcedo.socialma.setting.di

import com.msalcedo.socialma.app.di.AppComponent
import com.msalcedo.socialma.setting.SettingActivity
import dagger.Component

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SettingScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(SettingModule::class))
interface SettingComponent {
    fun inject(activity: SettingActivity): Unit
}