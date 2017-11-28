package com.msalcedo.socialma.common.mvp

import android.content.res.Resources
import com.msalcedo.socialma.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.msalcedo.socialma.models.ResponseError
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
interface ErrorMessageFactory {

    val moshi: Moshi
    val resources: Resources

    fun getErrorMessage(error: Throwable): String =
            when {
                (error is HttpException && error.code() in 400..499) -> getHttpErrorMessage(error)
                (error is HttpException && error.code() >= 500) -> resources.getString(R.string.error_internal_server)
                (error is IOException) -> resources.getString(R.string.error_connection_unavailable)
                else -> resources.getString(R.string.error_unknown)
            }

    private fun getHttpErrorMessage(error: HttpException): String =
            try {
                val body = error.response().errorBody()
                val adapter: JsonAdapter<ResponseError> = moshi.adapter(ResponseError::class.java)
                val errorResponse = adapter.fromJson(body!!.string())
                errorResponse.userMessage
            } catch (error: Exception) {
                resources.getString(R.string.error_unknown)
            }
}
