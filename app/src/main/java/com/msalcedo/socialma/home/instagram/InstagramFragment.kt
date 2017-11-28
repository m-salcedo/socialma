package com.msalcedo.socialma.home.instagram

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.home.instagram.di.DaggerInstagramComponent
import com.msalcedo.socialma.home.instagram.di.InstagramModule
import com.msalcedo.socialma.home.instagram.mvp.InstagramContract
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramFragment : Fragment(), InstagramContract.View.UI {

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
}