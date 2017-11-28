package com.msalcedo.socialma.app.modules.api

import com.msalcedo.socialma.common.storage.twitter.UserTwitter
import com.msalcedo.socialma.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
interface TwitterApi {

    @GET(Constant.Url.Twitter.User.FROM_ID)
    fun show(@Query(Constant.Key.USER_ID) id: Long): Call<UserTwitter>

}