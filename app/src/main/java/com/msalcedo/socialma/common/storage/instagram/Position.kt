package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Position {

    private val TAG = "TAG_${Position::class.java.simpleName}"

    @Json(name = "x")
    var x: Float? = null
    @Json(name = "y")
    var y: Float? = null
}