package com.msalcedo.socialma.common.mvp

import android.app.ProgressDialog
import android.widget.FrameLayout
import com.msalcedo.socialma.common.RxActivity
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
abstract class MVPView(override val activity: RxActivity): FrameLayout(activity), MVPContract.View {

    private var progressDialog: ProgressDialog? = null

    override fun showProgress(message: Int, cancelable: Boolean) {
        progressDialog = activity.indeterminateProgressDialog(message)
        progressDialog?.setCancelable(cancelable)
    }

    override fun showProgress(message: String, cancelable: Boolean) {
        progressDialog = activity.indeterminateProgressDialog(message)
        progressDialog?.setCancelable(cancelable)
    }

    override fun hideProgress() {
        if (progressDialog != null) {
            progressDialog?.dismiss()
            progressDialog = null
        }
    }

    override fun showToast(message: Int, longTime: Boolean) {
        if (longTime) activity.longToast(message)
        else activity.toast(message)
    }

    override fun showToast(message: String, longTime: Boolean) {
        if (longTime) activity.longToast(message)
        else activity.toast(message)
    }
}