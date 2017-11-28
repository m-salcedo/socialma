package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Images {

    private val TAG = "TAG_${Images::class.java.simpleName}"


    @Json(name = "thumbnail")
    var thumbnail: Thumbnail? = null
    @Json(name = "low_resolution")
    var lowResolution: LowResolution? = null
    @Json(name = "standard_resolution")
    var standardResolution: StandardResolution? = null
}