package com.yuan.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.itheima.player.model.bean.YueDanBean
import com.squareup.picasso.Picasso
import com.yuan.player.R
import kotlinx.android.synthetic.main.item_home.view.title
import kotlinx.android.synthetic.main.item_yuedan.view.*

class YueDanItemView: RelativeLayout {
    fun setData(data: YueDanBean.PlayListsBean) {
        title.text = data.title
        author_name.text = data.creator?.nickName
        count.text = data.videoCount.toString()
        Picasso.with(context).load(data.playListBigPic).into(bg)
        Picasso.with(context).load(data.creator?.smallAvatar).into(author_image)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    init {
        View.inflate(context, R.layout.item_yuedan,this)
    }
}