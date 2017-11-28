package com.msalcedo.socialma.app.modules.api

import com.msalcedo.socialma.common.storage.instagram.MediaRecent
import com.msalcedo.socialma.common.storage.instagram.UserInstagram
import com.msalcedo.socialma.utils.Constant
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
interface UserApi {

    @GET(Constant.Url.Instagram.User.BASE)
    fun self(@Query(Constant.Key.ACCESS_TOKEN) token: String): Single<UserInstagram>

    @GET(Constant.Url.Instagram.User.MEDIA_RECENT)
    fun mediaRecent(@Query(Constant.Key.ACCESS_TOKEN) token: String): Single<MediaRecent>
}