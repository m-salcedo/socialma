package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class StandardResolution {

    private val TAG = "TAG_${StandardResolution::class.java.simpleName}"

    @Json(name = "width")
    var width: Int? = null
    @Json(name = "height")
    var height: Int? = null
    @Json(name = "url")
    var url: String? = null
}