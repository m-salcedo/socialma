package com.msalcedo.socialma.home.base.mvp

import android.view.MenuItem
import com.msalcedo.socialma.common.mvp.ErrorMessageFactory
import com.msalcedo.socialma.common.mvp.MVPContract

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class HomeContract {

    interface Model : MVPContract.Model, ErrorMessageFactory {
        fun logout()
        fun getImage(): String
        fun getUserName(): String
        fun getFullname(): String
        fun isTwitter(): Boolean
    }

    interface View : MVPContract.View {

        val drawerListener: DrawerListener
        fun setImage(image: String)
        fun setUsername(userName: String)
        fun setName(name: String)
        fun setFullame(fullname: String)
        fun mount(id: Int)

        interface DrawerListener {
            fun mountTwitter()
            fun mountInstagram()
        }

    }

    interface Presenter : MVPContract.Presenter
}