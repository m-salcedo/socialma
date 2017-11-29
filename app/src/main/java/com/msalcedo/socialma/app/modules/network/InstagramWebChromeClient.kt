package com.msalcedo.socialma.app.modules.network

import android.webkit.WebChromeClient
import android.webkit.WebView


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/26/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramWebChromeClient : WebChromeClient() {

    private val TAG = "TAG_${InstagramWebChromeClient::class.java.simpleName}"

    override fun onProgressChanged(view: WebView, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
    }
}