package com.msalcedo.socialma.models

import android.os.Parcel
import android.os.Parcelable
import com.msalcedo.socialma.common.ext.createParcel

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
data class Session(
        val id: String? = null,
        val createdAt: String? = null
): Parcelable {

    companion object {
        @JvmField
        val CREATOR = createParcel {
            val id = it.readString()
            val createdAt = it.readString()

            Session(
                    id = id,
                    createdAt = createdAt)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(createdAt)
    }
}