package com.msalcedo.socialma.home.instagram.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msalcedo.socialma.R
import com.msalcedo.socialma.common.storage.instagram.Datum
import com.msalcedo.socialma.home.instagram.mvp.view.GridItemView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


/**
 * Created by Mariangela Salcedo (msalcedo047@gmail.com) on 11/19/17.
 * Copyright (c) 2017 m-salcedo. All rights reserved.
 */
class GridAdapter(val picasso: Picasso) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = "TAG_${GridAdapter::class.java.simpleName}"

    private var mItems: ArrayList<Datum> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val holder = holder as ViewHolder
        val item = mItems[position]

        picasso.load(item.images!!.thumbnail!!.url.toString()) // thumbnail url goes here
                .placeholder(R.drawable.ic_placeholder_square)
                .into(holder.ivImage, object : Callback {
                    override fun onError() {
                    }

                    override fun onSuccess() {
                        picasso.load(item.images!!.standardResolution!!.url) // image url goes here
                                .placeholder(holder.ivImage!!.drawable)
                                .into(holder.ivImage)
                    }
                })
    }

    override fun getItemCount(): Int = mItems.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val vi = LayoutInflater.from(parent!!.context)
        val v: View
        v = vi.inflate(R.layout.layout_grid_imageview, parent, false)
        return ViewHolder(v)
    }

    interface OnGridListener

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        private val root = view
        val ivImage: GridItemView? = root?.findViewById(R.id.gridImageView)
    }

    fun add(items: ArrayList<Datum>) {
        mItems = items
        notifyDataSetChanged()
    }
}