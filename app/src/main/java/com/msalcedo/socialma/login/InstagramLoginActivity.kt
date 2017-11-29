package com.msalcedo.socialma.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.modules.network.InstagramWebChromeClient
import com.msalcedo.socialma.app.modules.network.InstagramWebViewClient
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.utils.Constant
import kotlinx.android.synthetic.main.activity_login_instagram.*
import org.jetbrains.anko.intentFor


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/26/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramLoginActivity : RxActivity() {

    private val TAG = "TAG_${InstagramLoginActivity::class.java.simpleName}"

    private var instagramClient: InstagramWebViewClient = InstagramWebViewClient(this)

    companion object {
        val INSTAGRAM_LOGIN: Int = 5678
        fun start(activity: Activity) {
            val intent = activity.intentFor<InstagramLoginActivity>()
            activity.startActivityForResult(intent, INSTAGRAM_LOGIN)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_enter_bottom, R.anim.no_anim)
        setContentView(R.layout.activity_login_instagram)

        initWebView()

    }

    private fun initWebView() {

        webView.settings.javaScriptEnabled = true
        webView.clearCache(true)
        webView.webViewClient = instagramClient
        webView.webChromeClient = InstagramWebChromeClient()
        webView.loadUrl(Constant.Url.Instagram.AUTH)
    }

    override fun onBackPressed() {
        instagramClient.cancel()
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }

    fun result(intent: Intent?, error: String?) {
        if (intent != null) {
            setResult(Activity.RESULT_OK, intent)
        } else {
            if (error == null) {
                Toast.makeText(this, R.string.error_unknown, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
            }
            setResult(Activity.RESULT_OK)
        }
        finish()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.no_anim, R.anim.slide_exit_bottom)
    }
}