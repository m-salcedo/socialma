package com.msalcedo.socialma.home.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.RxActivity
import com.msalcedo.socialma.home.base.di.DaggerHomeComponent
import com.msalcedo.socialma.home.base.di.HomeModule
import com.msalcedo.socialma.home.base.mvp.HomeContract
import com.msalcedo.socialma.home.instagram.InstagramFragment
import com.msalcedo.socialma.home.twitter.TwitterListFragment
import com.msalcedo.socialma.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class HomeActivity : RxActivity(), HomeContract.View.DrawerListener {

    companion object {
        fun start(context: Context) = context.startActivity(context.intentFor<HomeActivity>())
    }

    @Inject
    lateinit var view: HomeContract.View

    @Inject
    lateinit var presenter: HomeContract.Presenter

    private var twitterListFragment: TwitterListFragment? = null
    private var instagramFragment: InstagramFragment? = null
    private var activeFragmentTag: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.no_anim, R.anim.no_anim)
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
            R.id.nav_manage -> SettingActivity.start(this)
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun showActiveFragment(fragment: Fragment, tag: String) {
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, fragment, tag)
                    .commit()
        }
        supportFragmentManager
                .beginTransaction()
                .show(fragment)
                .commit()

        activeFragmentTag = tag
    }

    private fun hideActiveFragment() {
        if (!TextUtils.isEmpty(activeFragmentTag)) {
            supportFragmentManager
                    .beginTransaction()
                    .hide(supportFragmentManager.findFragmentByTag(activeFragmentTag))
                    .commit()
        }
    }

    override fun mountTwitter() {

        hideActiveFragment()

        if (twitterListFragment == null) {
            twitterListFragment = TwitterListFragment()
        }

        showActiveFragment(twitterListFragment!!, TwitterListFragment.TAG)
    }

    override fun mountInstagram() {

        hideActiveFragment()

        if (instagramFragment == null) {
            instagramFragment = InstagramFragment()
        }

        showActiveFragment(instagramFragment!!, InstagramFragment.TAG)
    }

    private fun initializeComponent() {
        DaggerHomeComponent.builder()
                .appComponent(Application.component)
                .homeModule(HomeModule(this))
                .build()
                .inject(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (TextUtils.isEmpty(activeFragmentTag) && activeFragmentTag == TwitterListFragment.TAG) {
            twitterListFragment!!.onActivityResult(requestCode, resultCode, data)
        } else {
            instagramFragment!!.onActivityResult(requestCode, resultCode, data)
        }
    }
}
