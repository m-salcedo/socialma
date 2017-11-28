package com.msalcedo.socialma.home.twitter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.home.twitter.di.DaggerTwitterListComponent
import com.msalcedo.socialma.home.twitter.di.TwitterListModule
import com.msalcedo.socialma.home.twitter.mvp.TwitterListContract
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class TwitterListFragment : Fragment(), TwitterListContract.View.UI {

    @Inject lateinit var view: TwitterListContract.View
    @Inject lateinit var presenter: TwitterListContract.Presenter

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
        DaggerTwitterListComponent.builder()
                .appComponent(Application.component)
                .twitterListModule(TwitterListModule(this))
                .build()
                .inject(this)
    }
}