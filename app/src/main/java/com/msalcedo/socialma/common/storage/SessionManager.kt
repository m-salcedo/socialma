package com.msalcedo.socialma.common.storage

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.msalcedo.socialma.app.di.AppQualifier
import com.msalcedo.socialma.app.di.AppScope
import com.msalcedo.socialma.common.ext.saveString
import com.msalcedo.socialma.common.storage.instagram.Data
import com.msalcedo.socialma.common.storage.twitter.UserTwitter
import com.msalcedo.socialma.models.Session
import com.msalcedo.socialma.utils.Constant
import com.squareup.moshi.Moshi
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@AppScope
class SessionManager @Inject constructor(@AppQualifier context: Context, moshi: Moshi) {

    private val TAG = "TAG_${SessionManager::class.java.simpleName}"

    private val preferences = context.getSharedPreferences(Constant.Preferences.SESSION, Context.MODE_PRIVATE)
    private val authAdapter = moshi.adapter(Auth::class.java)
    private val authSubject = PublishSubject.create<Auth>()
    private val userInstagramAdapter = moshi.adapter(Data::class.java)
    private val userInstagramSubject = PublishSubject.create<Data>()
    private val userTwitterAdapter = moshi.adapter(UserTwitter::class.java)
    private val userTwitterSubject = PublishSubject.create<UserTwitter>()
    private val sessionSubject = PublishSubject.create<Session>()
    private val sessionAdapter = moshi.adapter(Session::class.java)

    val sessionObservable: Observable<Session> = sessionSubject

    val isLoggedIn: Boolean
        get() = auth != null && (!TextUtils.isEmpty(auth!!.tokenInstagram) || !TextUtils.isEmpty(auth!!.tokenTwitter))

    val userName: String
        get() {
            if (userTwitter != null && !TextUtils.isEmpty(userTwitter!!.screenName)) {
                return userTwitter!!.screenName!!
            } else if (userInstagram != null && !TextUtils.isEmpty(userInstagram!!.username)) {
                return userInstagram!!.username.toString()
            }
            return ""
        }

    val avatar: String
        get() {
            if (userTwitter != null && !TextUtils.isEmpty(userTwitter!!.screenName)) {
                return "https://twitter.com/${userTwitter!!.screenName}/profile_image?size=original"
            } else if (userInstagram != null && !TextUtils.isEmpty(userInstagram!!.profilePicture)) {
                return userInstagram!!.profilePicture!!
            }
            return "error"
        }

    val fullname: String
        get() {
            if (userTwitter != null && !TextUtils.isEmpty(userTwitter!!.name)) {
                return userTwitter!!.name!!
            } else if (userInstagram != null && !TextUtils.isEmpty(userInstagram!!.fullName)) {
                return userInstagram!!.fullName!!
            }
            return ""
        }

    var auth: Auth?
        @Synchronized
        set(value) {
            if (value == null) {
                preferences.edit().remove(Constant.Key.AUTH).apply()
            } else {
                preferences.saveString(Constant.Key.AUTH, authAdapter.toJson(value))
                authSubject.onNext(value)
            }
        }
        get() {
            return try {
                authAdapter.fromJson(preferences.getString(Constant.Key.AUTH, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                null
            }
        }

    var userInstagram: Data?
        @Synchronized
        set(value) {
            if (value == null) {
                preferences.edit().remove(Constant.Key.USER_INSTAGRAM).apply()
            } else {
                preferences.saveString(Constant.Key.USER_INSTAGRAM, userInstagramAdapter.toJson(value))
                userInstagramSubject.onNext(value)
            }
        }
        get() {
            return try {
                userInstagramAdapter.fromJson(preferences.getString(Constant.Key.USER_INSTAGRAM, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                null
            }
        }

    var userTwitter: UserTwitter?
        @Synchronized
        set(value) {
            if (value == null) {
                preferences.edit().remove(Constant.Key.USER_TWITTER).apply()
            } else {
                preferences.saveString(Constant.Key.USER_TWITTER, userTwitterAdapter.toJson(value))
                userTwitterSubject.onNext(value)
            }
        }
        get() {
            return try {
                userTwitterAdapter.fromJson(preferences.getString(Constant.Key.USER_TWITTER, ""))
            } catch (error: Exception) {
                Log.e(TAG, error.message)
                error.printStackTrace()
                null
            }
        }

    fun clear() = preferences.edit().clear().apply()
}


