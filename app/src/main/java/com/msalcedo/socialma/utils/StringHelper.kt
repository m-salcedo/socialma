package com.msalcedo.socialma.utils

import com.google.gson.Gson

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/25/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class StringHelper {


    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // Constants
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------

    private val TAG = "TAG_${StringHelper::class.java.simpleName}"
    private val INDEX_NOT_FOUND = -1

    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------------------

    fun toString(o: Any?): String {
        return Gson().toJson(o)
    }
}