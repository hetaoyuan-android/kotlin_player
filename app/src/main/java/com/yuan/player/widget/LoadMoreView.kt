package com.yuan.player.widget

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import com.yuan.player.R

class LoadMoreView: RelativeLayout {
    constructor(context: Context?):super(context)

    init {
        View.inflate(context, R.layout.view_loadmore, this)
    }
}