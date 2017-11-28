package com.msalcedo.socialma.home.instagram.mvp.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/28/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class GridItemView : ImageView {

    private val TAG = "TAG_${GridItemView::class.java.simpleName}"

    constructor(context: Context): super(context)


    constructor(context: Context, attrs: AttributeSet): super(context, attrs)


    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle)

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec) // This is the   key that will make the height equivalent to its width
    }
}