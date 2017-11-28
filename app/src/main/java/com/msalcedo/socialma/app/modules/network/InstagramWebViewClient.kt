package com.msalcedo.socialma.app.modules.network

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.msalcedo.socialma.login.InstagramLoginActivity
import com.msalcedo.socialma.utils.Constant


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/26/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramWebViewClient(val activity: InstagramLoginActivity) : WebViewClient() {

    private val TAG = "TAG_${InstagramWebViewClient::class.java.simpleName}"

    private var canceled: Boolean = false

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        if (url!!.contains(Constant.Url.Instagram.REDIRECT_URI_TOKEN)) {
            val returnIntent = Intent()
            returnIntent.putExtra(Constant.Key.ACCESS_TOKEN, url.removePrefix(Constant.Url.Instagram.REDIRECT_URI_TOKEN))
            activity.result(returnIntent, null)
        }
    }

    override fun onPageFinished(view: WebView?, url: String?) {
    }

    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        if (!canceled) {
            if (error != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    activity.result(null, error = error.description.toString())
                }
            } else {
                activity.result(null, null)
            }
        }
    }

    fun cancel() {
        canceled = true
    }
}