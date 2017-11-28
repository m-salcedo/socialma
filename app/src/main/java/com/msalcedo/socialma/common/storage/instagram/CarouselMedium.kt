package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class CarouselMedium {

    private val TAG = "TAG_${CarouselMedium::class.java.simpleName}"

    @Json(name = "images")
    var images: Images? = null
    @Json(name = "users_in_photo")
    var usersInPhoto: List<UsersInPhoto>? = null
    @Json(name = "type")
    var type: String? = null
}