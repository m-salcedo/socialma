package com.msalcedo.socialma.home.instagram.mvp

import com.msalcedo.socialma.common.mvp.ErrorMessageFactory
import com.msalcedo.socialma.common.mvp.MVPContract
import com.msalcedo.socialma.common.storage.Auth
import com.msalcedo.socialma.common.storage.instagram.MediaRecent
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramContract {
    interface Model : MVPContract.Model, ErrorMessageFactory {
        var mediaRecent: MediaRecent?
        fun finish()
        fun getAvatar(): String
        fun getPosts(): String
        fun getFollowedBy(): String
        fun getFollows(): String
        fun getFullname(): String
        fun getUsername(): String
        fun getBio(): String
        fun getWebsite(): String
        fun getMediaRecent(): Completable
        fun authInstagram(auth: Auth): Completable
        fun getAuthCurrent(): Auth
        fun isInstagram(): Boolean
    }

    interface View : MVPContract.View {
        val loginInstagramObservable: Observable<Any>?
        val uiListener: UI
        fun setAvatar(avatar: String)
        fun setPosts(posts: String)
        fun setFollowedBy(followedBy: String)
        fun setFollows(follows: String)
        fun setFullname(fullname: String)
        fun setDescription(description: String)
        fun setWebSite(website: String)
        fun setUsername(username: String)
        fun loadGrid(mediaRecent: MediaRecent?)
        fun startInstagram()
        fun hideEmptyLogin()
        fun showEmptyLogin()

        interface UI {
            fun inflated()
        }
    }

    interface Presenter : MVPContract.Presenter {
        fun initView()
        fun setInstagramToken(accessToken: String?)
        fun isVisible()
    }
}