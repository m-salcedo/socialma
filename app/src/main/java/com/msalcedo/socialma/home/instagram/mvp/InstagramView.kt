package com.msalcedo.socialma.home.instagram.mvp

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.ext.inflate
import com.msalcedo.socialma.common.mvp.MVPView
import com.msalcedo.socialma.common.storage.instagram.MediaRecent
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.home.instagram.utils.GridAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_center_profile.view.*
import kotlinx.android.synthetic.main.snippet_top_profile.view.*
import android.support.v7.widget.GridLayoutManager
import com.jakewharton.rxbinding2.view.RxView
import com.msalcedo.socialma.common.storage.instagram.Datum
import com.msalcedo.socialma.login.InstagramLoginActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_instagram.view.*


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SuppressLint("ViewConstructor")
class InstagramView(
        override val activity: HomeActivity,
        override val uiListener: InstagramContract.View.UI,
        val picasso: Picasso) : MVPView(activity), InstagramContract.View, GridAdapter.OnGridListener {

    override var loginInstagramObservable: Observable<Any>? = null

    private lateinit var adapter: GridAdapter

    override fun setPosts(posts: String) {
        tvPosts.text = posts
    }

    override fun setFollowedBy(followedBy: String) {
        tvFollowers.text = followedBy
    }

    override fun setFollows(follows: String) {
        tvFollowing.text = follows
    }

    override fun setFullname(fullname: String) {
        tvDisplayName.text = fullname
    }

    override fun setDescription(description: String) {
        tvDescription.text = description
    }

    override fun setWebSite(website: String) {
        tvWebsite.text = website
    }

    override fun setUsername(username: String) {
        tvUsername.text = "@$username"
    }

    override fun loadGrid(mediaRecent: MediaRecent?) {
        adapter.add((mediaRecent!!.data as ArrayList<Datum>?)!!)
    }

    override fun startInstagram() {
        InstagramLoginActivity.start(activity)
    }

    override fun setAvatar(avatar: String) {
        picasso.load(avatar)
                .placeholder(R.drawable.ic_image_profile)
                .into(ivProfilePhoto)
    }

    private fun getInstagramRx(): Observable<Any> {

        return RxView.clicks(btnInstagram)
    }

    override fun showEmptyLogin() {
        llEmpty.visibility = View.VISIBLE
        relLayoutCenter.visibility = View.GONE

        loginInstagramObservable = getInstagramRx()
    }

    override fun hideEmptyLogin() {
        llEmpty.visibility = View.GONE
        relLayoutCenter.visibility = View.VISIBLE
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val root = inflate(R.layout.fragment_instagram, true)
        uiListener.inflated()
        adapter = GridAdapter(this, picasso)
        gridView.layoutManager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        gridView.isNestedScrollingEnabled = false
        gridView.adapter = adapter
        return root
    }
}