package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class UserInstagram {

    private val TAG = "TAG_${UserInstagram::class.java.simpleName}"

    @Json(name = "data")
    var data: Data? = null
}