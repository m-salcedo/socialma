package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Caption {

    private val TAG = "TAG_${Caption::class.java.simpleName}"

    @Json(name = "id")
    var id: String? = null
    @Json(name = "text")
    var text: String? = null
    @Json(name = "created_time")
    var createdTime: String? = null
    @Json(name = "from")
    var from: From? = null

}