package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Counts {

    private val TAG = "TAG_${Counts::class.java.simpleName}"

    @Json(name = "media")
    var media: Int? = null
    @Json(name = "follows")
    var follows: Int? = null
    @Json(name = "followed_by")
    var followedBy: Int? = null

}