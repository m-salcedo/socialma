package com.msalcedo.socialma.app.modules.network

import android.content.Context
import com.msalcedo.socialma.app.di.AppQualifier
import com.msalcedo.socialma.app.di.AppScope
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.setting.SettingActivity
import com.msalcedo.socialma.utils.Constant
import okhttp3.Interceptor
import okhttp3.Response
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@AppScope
class AuthenticationInterceptor @Inject constructor(
        @AppQualifier val context: Context,
        val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {

        val request = chain
                ?.request()
                ?.newBuilder()
                ?.build()

        val response = chain?.proceed(request)
        val code = response?.code()

        if (code == Constant.Network.Status.UNAUTHORIZED ||
                code == Constant.Network.Status.FORBIDDEN) {
            context.apply { startActivity(intentFor<SettingActivity>()) }
        }

        return response
    }
}