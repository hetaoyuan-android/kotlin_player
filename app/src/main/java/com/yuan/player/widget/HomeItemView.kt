package com.yuan.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.itheima.player.model.bean.HomeItemBean
import com.squareup.picasso.Picasso
import com.yuan.player.R
import kotlinx.android.synthetic.main.item_home.view.*


/**
 * ClassName:HomeItemView
 * Description:
 */
class HomeItemView:RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 初始化方法
     */
    init {
        View.inflate(context, R.layout.item_home,this)
    }

    /**
     * 刷新条目view数据
     */
    fun setData(data: HomeItemBean) {
        //歌曲名称
        title.text = data.title
        //简介
        desc.text = data.description
        //背景图片
        Picasso.with(context).load(data.posterPic).into(bg)
    }
}