package com.msalcedo.socialma.home.base

import android.content.Context
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.common.ext.replace
import com.msalcedo.socialma.home.base.di.DaggerHomeComponent
import com.msalcedo.socialma.home.base.di.HomeModule
import com.msalcedo.socialma.home.base.mvp.HomeContract
import com.msalcedo.socialma.home.instagram.InstagramFragment
import com.msalcedo.socialma.home.twitter.TwitterListFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class HomeActivity: RxActivity(), HomeContract.View.DrawerListener {

    companion object {
        fun start(context: Context) = context.startActivity(context.intentFor<HomeActivity>())
    }

    @Inject
    lateinit var view: HomeContract.View

    @Inject
    lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeComponent()
        setContentView(view.inflateLayout())
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_manage -> settingsActivity()
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun settingsActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mountTwitter() {
        supportFragmentManager.replace(R.id.container, TwitterListFragment())
    }

    override fun mountInstagram() {
        supportFragmentManager.replace(R.id.container, InstagramFragment())
    }

    private fun initializeComponent() {
        DaggerHomeComponent.builder()
                .appComponent(Application.component)
                .homeModule(HomeModule(this))
                .build()
                .inject(this)
    }
}
