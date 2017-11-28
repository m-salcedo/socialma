package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Count {

    private val TAG = "TAG_${Count::class.java.simpleName}"

    @Json(name = "count")
    var count: Int? = null
}