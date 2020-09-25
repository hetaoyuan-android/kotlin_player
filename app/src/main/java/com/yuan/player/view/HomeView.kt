package com.yuan.player.view

import com.itheima.player.model.bean.HomeItemBean


interface HomeView {
    fun onError(message: String)
    fun loadSuccess(list: MutableList<HomeItemBean>)
    fun loadMoreSuccess(list: MutableList<HomeItemBean>)
}