package com.msalcedo.socialma.setting.mvp

import android.app.Activity
import android.app.Activity.RESULT_OK
import com.msalcedo.socialma.common.storage.Auth
import com.msalcedo.socialma.common.storage.SessionManager
import com.msalcedo.socialma.login.LoginActivity

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class SettingModel(
        val activity: Activity,
        val sessionManager: SessionManager) : SettingContract.Model {

    override val isInstagramLogin: Boolean
        get() = sessionManager.auth != null && sessionManager.auth!!.tokenInstagram != null

    override val isTwitterLogin: Boolean
        get() = sessionManager.auth != null && sessionManager.auth!!.tokenTwitter != null

    override fun startLoginActivity() {
        sessionManager.clear()
        activity.finish()
        LoginActivity.start(activity)
    }

    override fun logoutInstagram() {
        var auth = sessionManager.auth
        sessionManager.auth = Auth(
                null,
                auth!!.tokenTwitter,
                auth.secretTwitter,
                auth.userNameTwitter,
                auth.userIdTwitter)
        sessionManager.userInstagram = null
    }

    override fun logoutTwitter() {
        var auth = sessionManager.auth
        sessionManager.auth = Auth(
                auth!!.tokenInstagram,
                null,
                null,
                null,
                null)
        sessionManager.userTwitter = null
    }

}