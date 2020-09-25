package com.yuan.player.view

import com.itheima.player.model.bean.HomeItemBean
import com.itheima.player.model.bean.YueDanBean

interface YueDanView {

    fun onError(message: String?)
    fun loadSuccess(response: YueDanBean?)
    fun loadMoreSuccess(response: YueDanBean?)
}