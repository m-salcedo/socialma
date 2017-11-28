package com.msalcedo.socialma.home.twitter.mvp

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.R
import com.msalcedo.socialma.app.Application
import com.msalcedo.socialma.common.ext.inflate
import com.msalcedo.socialma.common.mvp.MVPView
import com.msalcedo.socialma.home.base.HomeActivity
import com.msalcedo.socialma.utils.StringHelper
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.core.models.Tweet
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import com.twitter.sdk.android.tweetui.UserTimeline
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_twitter_list.view.*

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
@SuppressLint("ViewConstructor")
class TwitterListView(
        override val activity: HomeActivity, override val uiListener: TwitterListContract.View.UI) : MVPView(activity), TwitterListContract.View {

    override var loginTwitterObservable: Observable<TwitterSession>? = null

    override fun createAdapter(userTimeLine: UserTimeline) {
        Log.d("TAG__", "loadGrid")

        val actionCallback = object : Callback<Tweet>() {
            override fun success(result: Result<Tweet>) {
                Log.d("TAG__", StringHelper().toString(result))
            }

            override fun failure(exception: TwitterException) {
                if (exception is TwitterAuthException) {
                    Log.e("TAG__", "TwitterAuthException")
                }

                Log.d("TAG__", StringHelper().toString(exception), exception)
            }
        }

        val adapter = TweetTimelineListAdapter.Builder(activity)
                .setTimeline(userTimeLine)
                .setOnActionCallback(actionCallback)
                .build()

        twitterList.adapter = adapter

    }

    private fun getTwitterRx(): Observable<TwitterSession> {
        Log.d("TAG__", "antes de getTwitterRx")

        return Observable.create { subscriber ->

            if (Application.component.twitterSession().authToken.secret != null) {
                TwitterCore.getInstance().sessionManager.clearActiveSession()
            }
            Log.d("TAG__", "antes de regis")

            btnTwitter.callback = object : Callback<TwitterSession>() {
                override fun success(result: Result<TwitterSession>) {
                    Log.d("TAG__", "antes de onNext")
                    subscriber.onNext(result.data)
                }

                override fun failure(exception: TwitterException) {
                    Log.e("TAG__", "antes de onNext")
                    subscriber.onError(exception)
                }

            }
        }
    }

    override fun showEmptyLogin() {
        llEmpty.visibility = View.VISIBLE

        loginTwitterObservable = getTwitterRx()
    }

    override fun hideEmptyLogin() {
        llEmpty.visibility = View.GONE
    }

    override fun inflateLayout(container: ViewGroup?): View? {
        val root = inflate(R.layout.fragment_twitter_list, true)
        uiListener.inflated()
        return root
    }
}