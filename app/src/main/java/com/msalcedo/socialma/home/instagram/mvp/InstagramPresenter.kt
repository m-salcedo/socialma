package com.msalcedo.socialma.home.instagram.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class InstagramPresenter(
        override val view: InstagramContract.View,
        override val model: InstagramContract.Model) : InstagramContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {

    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    override fun initView() {
        view.setAvatar(model.getAvatar())
        view.setPosts(model.getPosts())
        view.setFollowedBy(model.getFollowedBy())
        view.setFollows(model.getFollows())
        view.setFullname(model.getFullname())
        view.setUsername(model.getUsername())
        view.setDescription(model.getBio())
        view.setWebSite(model.getWebsite())

        val disposable = model.getMediaRecent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ success() },
                        { failed(it) })
        compositeDisposable.add(disposable)

    }

    private fun success() {
        view.loadGrid(model.mediaRecent)
    }

    private fun failed(it: Throwable) {
        view.showToast(model.getErrorMessage(it))
        view.hideProgress()
    }
}