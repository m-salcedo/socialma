package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class UsersInPhoto {

    private val TAG = "TAG_${UsersInPhoto::class.java.simpleName}"

    @Json(name = "user")
    var user: User? = null
    @Json(name = "position")
    var position: Position? = null

}