package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class User {

    private val TAG = "TAG_${User::class.java.simpleName}"

    @Json(name = "id")
    var id: String? = null
    @Json(name = "full_name")
    var fullName: String? = null
    @Json(name = "profile_picture")
    var profilePicture: String? = null
    @Json(name = "username")
    var username: String? = null
}