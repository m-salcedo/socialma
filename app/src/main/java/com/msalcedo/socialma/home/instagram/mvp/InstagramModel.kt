package com.msalcedo.socialma.home.instagram.mvp

import android.content.res.Resources
import com.msalcedo.socialma.app.modules.api.UserApi
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.common.storage.instagram.MediaRecent
import com.msalcedo.socialma.home.base.HomeActivity
import com.squareup.moshi.Moshi
import io.reactivex.Completable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramModel(
        override val moshi: Moshi,
        override val resources: Resources,
        val activity: HomeActivity,
        val sessionManager: SessionManager,
        val userApi: UserApi
) : InstagramContract.Model {

    override var mediaRecent: MediaRecent? = null

    override fun getAvatar(): String {
        return sessionManager.userInstagram!!.profilePicture!!
    }

    override fun getPosts(): String {
        return sessionManager.userInstagram!!.counts!!.media.toString()
    }

    override fun getFollowedBy(): String {
        return sessionManager.userInstagram!!.counts!!.followedBy.toString()
    }

    override fun getFollows(): String {
        return sessionManager.userInstagram!!.counts!!.follows.toString()
    }

    override fun getFullname(): String {
        return sessionManager.userInstagram!!.fullName!!
    }

    override fun getUsername(): String {
        return sessionManager.userInstagram!!.username!!
    }

    override fun getBio(): String {
        return sessionManager.userInstagram!!.bio!!
    }

    override fun getWebsite(): String {
        return sessionManager.userInstagram!!.website!!
    }


    override fun getMediaRecent(): Completable =
            userApi.mediaRecent(sessionManager.auth!!.tokenInstagram!!)
                    .doOnSuccess {
                        mediaRecent = it
                    }
                    .toCompletable()


    override fun finish() {
        activity.finish()
    }

}