package com.msalcedo.socialma.common.storage.twitter

import com.google.gson.annotations.SerializedName


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/27/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class UserTwitter {

    private val TAG = "TAG_${UserTwitter::class.java.simpleName}"

    @SerializedName("id")
    var id: Int? = null
    @SerializedName("id_str")
    var idStr: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("screen_name")
    var screenName: String? = null
    @SerializedName("location")
    var location: String? = null
    @SerializedName("profile_location")
    var profileLocation: Any? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("protected")
    var _protected: Boolean? = null
    @SerializedName("followers_count")
    var followersCount: Int? = null
    @SerializedName("friends_count")
    var friendsCount: Int? = null
    @SerializedName("listed_count")
    var listedCount: Int? = null
    @SerializedName("created_at")
    var createdAt: String? = null
    @SerializedName("favourites_count")
    var favouritesCount: Int? = null
    @SerializedName("utc_offset")
    var utcOffset: Int? = null
    @SerializedName("time_zone")
    var timeZone: String? = null
    @SerializedName("geo_enabled")
    var geoEnabled: Boolean? = null
    @SerializedName("verified")
    var verified: Boolean? = null
    @SerializedName("statuses_count")
    var statusesCount: Int? = null
    @SerializedName("lang")
    var lang: String? = null
    @SerializedName("contributors_enabled")
    var contributorsEnabled: Boolean? = null
    @SerializedName("is_translator")
    var isTranslator: Boolean? = null
    @SerializedName("is_translation_enabled")
    var isTranslationEnabled: Boolean? = null
    @SerializedName("profile_background_color")
    var profileBackgroundColor: String? = null
    @SerializedName("profile_background_image_url")
    var profileBackgroundImageUrl: String? = null
    @SerializedName("profile_background_image_url_https")
    var profileBackgroundImageUrlHttps: String? = null
    @SerializedName("profile_background_tile")
    var profileBackgroundTile: Boolean? = null
    @SerializedName("profile_image_url")
    var profileImageUrl: String? = null
    @SerializedName("profile_image_url_https")
    var profileImageUrlHttps: String? = null
    @SerializedName("profile_banner_url")
    var profileBannerUrl: String? = null
    @SerializedName("profile_link_color")
    var profileLinkColor: String? = null
    @SerializedName("profile_sidebar_border_color")
    var profileSidebarBorderColor: String? = null
    @SerializedName("profile_sidebar_fill_color")
    var profileSidebarFillColor: String? = null
    @SerializedName("profile_text_color")
    var profileTextColor: String? = null
    @SerializedName("profile_use_background_image")
    var profileUseBackgroundImage: Boolean? = null
    @SerializedName("has_extended_profile")
    var hasExtendedProfile: Boolean? = null
    @SerializedName("default_profile")
    var defaultProfile: Boolean? = null
    @SerializedName("default_profile_image")
    var defaultProfileImage: Boolean? = null
    @SerializedName("following")
    var following: Any? = null
    @SerializedName("follow_request_sent")
    var followRequestSent: Any? = null
    @SerializedName("notifications")
    var notifications: Any? = null
    @SerializedName("translator_type")
    var translatorType: String? = null
}