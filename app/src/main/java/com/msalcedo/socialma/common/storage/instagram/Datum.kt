package com.msalcedo.socialma.common.storage.instagram

import com.squareup.moshi.Json

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class Datum {

    private val TAG = "TAG_${Datum::class.java.simpleName}"
    @Json(name = "id")
    var id: String? = null
    @Json(name = "user")
    var user: User? = null
    @Json(name = "images")
    var images: Images? = null
    @Json(name = "created_time")
    var createdTime: String? = null
    @Json(name = "caption")
    var caption: Caption? = null
    @Json(name = "user_has_liked")
    var userHasLiked: Boolean? = null
    @Json(name = "likes")
    var likes: Count? = null
    @Json(name = "tags")
    var tags: List<String>? = null
    @Json(name = "filter")
    var filter: String? = null
    @Json(name = "comments")
    var comments: Count? = null
    @Json(name = "type")
    var type: String? = null
    @Json(name = "link")
    var link: String? = null
    @Json(name = "location")
    var location: Any? = null
    @Json(name = "attribution")
    var attribution: Any? = null
    @Json(name = "users_in_photo")
    var usersInPhoto: List<UsersInPhoto>? = null
    @Json(name = "carousel_media")
    var carouselMedia: List<CarouselMedium>? = null

}