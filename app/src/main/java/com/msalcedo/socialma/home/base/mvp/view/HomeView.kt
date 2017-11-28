package com.msalcedo.socialma.home.base.mvp.view

import android.annotation.SuppressLint
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.ext.inflate
import com.msalcedo.socialma.common.mvp.MVPView
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.home.base.mvp.HomeContract
import com.msalcedo.socialma.setting.SettingActivity
import com.squareup.picasso.Picasso
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.app_bar_main.view.*


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SuppressLint("ViewConstructor")
class HomeView(
        override val activity: HomeActivity,
        val picasso: Picasso,
        override val drawerListener: HomeContract.View.DrawerListener
) : MVPView(activity), HomeContract.View, NavigationView.OnNavigationItemSelectedListener {

    private val logoutSubject = PublishSubject.create<Any>()

    private lateinit var tvName: TextView
    private lateinit var tvUsername: TextView
    private lateinit var imageView: ImageView

    override fun inflateLayout(container: ViewGroup?): View {
        val root = inflate(R.layout.activity_main, true)

        val toggle = ActionBarDrawerToggle(
                activity, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        tvName = nav_view.getHeaderView(0).findViewById(R.id.tvName)
        tvUsername = nav_view.getHeaderView(0).findViewById(R.id.tvUsername)
        imageView = nav_view.getHeaderView(0).findViewById(R.id.imageView)

        return root
    }

    override fun setName(name: String) {
        tvName.text = name
    }

    override fun setUsername(userName: String) {
        tvUsername.text = userName
    }

    override fun setImage(image: String) {
        picasso.load(image)
                .placeholder(R.drawable.ic_image_profile)
                .into(imageView)
    }

    override fun setFullame(fullname: String) {
        tvName.text = fullname
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mount(item.itemId)
        return false
    }

    override fun mount(id: Int) {
        when (id) {
            R.id.nav_twitter -> {
                toolbar.setTitle(R.string.title_twitter)
                drawerListener.mountTwitter()
            }
            R.id.nav_instagram -> {
                toolbar.setTitle(R.string.title_instagram)
                drawerListener.mountInstagram()
            }
            R.id.nav_manage -> {
                SettingActivity.start(activity)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
    }
}