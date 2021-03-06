package com.msalcedo.socialma.home.instagram.mvp

import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.storage.Auth
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
        isVisible()
        if (model.isInstagram()) {
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
    }

    override fun isVisible() {
        if (!model.isInstagram()) {
            view.showEmptyLogin()
            compositeDisposable.remove(view.loginInstagramObservable!!.subscribe())
            compositeDisposable.add(view.loginInstagramObservable!!.subscribe { loginInstagram() })
        } else {
            view.hideEmptyLogin()
        }
    }

    override fun setInstagramToken(accessToken: String?) {
        view.showProgress(R.string.loading)
        val authCurrent = model.getAuthCurrent()
        val auth = Auth(accessToken,
                authCurrent.tokenTwitter,
                authCurrent.secretTwitter,
                authCurrent.userNameTwitter,
                authCurrent.userIdTwitter)
        val disposable = model.authInstagram(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.hideProgress()
                    initView()
                }, { failed(it) })
        compositeDisposable.add(disposable)
    }

    private fun loginInstagram() {
        view.startInstagram()
    }

    private fun success() {
        view.loadGrid(model.mediaRecent)
    }

    private fun failed(it: Throwable) {
        view.showToast(model.getErrorMessage(it))
        view.hideProgress()
    }
}