package com.msalcedo.socialma.home.instagram

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.home.instagram.di.DaggerInstagramComponent
import com.msalcedo.socialma.home.instagram.di.InstagramModule
import com.msalcedo.socialma.home.instagram.mvp.InstagramContract
import com.msalcedo.socialma.login.InstagramLoginActivity
import com.msalcedo.socialma.utils.Constant
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramFragment : Fragment(), InstagramContract.View.UI {

    companion object {
        val TAG = "TAG_${InstagramFragment::class.java.simpleName}"
    }

    @Inject lateinit var view: InstagramContract.View
    @Inject lateinit var presenter: InstagramContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeComponent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return view.inflateLayout(container)
    }

    override fun inflated() {
        presenter.initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun initializeComponent() {
        DaggerInstagramComponent.builder()
                .appComponent(Application.component)
                .instagramModule(InstagramModule(this))
                .build()
                .inject(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == InstagramLoginActivity.INSTAGRAM_LOGIN) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    val accessToken = data!!.getStringExtra(Constant.Key.ACCESS_TOKEN)
                    presenter.setInstagramToken(accessToken)
                }
                Activity.RESULT_CANCELED -> {

                }
                else -> {

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.isVisible()
    }

}