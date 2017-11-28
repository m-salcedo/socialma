package com.msalcedo.socialma.app.modules.api

import com.msalcedo.socialma.common.CallExecuteSingle
import com.msalcedo.socialma.common.storage.Auth
import com.msalcedo.socialma.common.storage.twitter.UserTwitter
import com.twitter.sdk.android.core.TwitterApiClient
import com.twitter.sdk.android.core.TwitterSession
import okhttp3.OkHttpClient

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class MyTwitterApiClient : TwitterApiClient {

    private val TAG = "TAG_${MyTwitterApiClient::class.java.simpleName}"

    constructor(client: OkHttpClient) : super(client)
    constructor(session: TwitterSession?, client: OkHttpClient?) : super(session, client)

    fun getCustomService(): TwitterApi {
        return getService<TwitterApi>(TwitterApi::class.java)
    }

    companion object {
        fun completableTwitterAuth(myTwitterApiClient: MyTwitterApiClient, auth: Auth): CallExecuteSingle<UserTwitter> {
            return CallExecuteSingle(
                    myTwitterApiClient.getCustomService().show(auth.userIdTwitter!!))
        }
    }
}