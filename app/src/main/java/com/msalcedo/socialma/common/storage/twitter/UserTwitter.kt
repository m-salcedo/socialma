package com.msalcedo.socialma.common.storage.twitter

import com.squareup.moshi.Json


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class UserTwitter {

    private val TAG = "TAG_${UserTwitter::class.java.simpleName}"

    @Json(name = "id")
    var id: Int? = null
    @Json(name = "id_str")
    var idStr: String? = null
    @Json(name = "name")
    var name: String? = null
    @Json(name = "screen_name")
    var screenName: String? = null
    @Json(name = "description")
    var description: String? = null
    @Json(name = "protected")
    var _protected: Boolean? = null
    @Json(name = "followers_count")
    var followersCount: Int? = null
    @Json(name = "friends_count")
    var friendsCount: Int? = null
    @Json(name = "profile_background_image_url")
    var profileBackgroundImageUrl: String? = null
    @Json(name = "profile_background_image_url_https")
    var profileBackgroundImageUrlHttps: String? = null
    @Json(name = "profile_background_tile")
    var profileBackgroundTile: Boolean? = null
    @Json(name = "profile_image_url")
    var profileImageUrl: String? = null
    @Json(name = "profile_image_url_https")
    var profileImageUrlHttps: String? = null
    @Json(name = "profile_banner_url")
    var profileBannerUrl: String? = null
    @Json(name = "profile_link_color")
    var profileLinkColor: String? = null
    @Json(name = "profile_sidebar_border_color")
    var profileSidebarBorderColor: String? = null
    @Json(name = "profile_sidebar_fill_color")
    var profileSidebarFillColor: String? = null
    @Json(name = "profile_text_color")
    var profileTextColor: String? = null
}