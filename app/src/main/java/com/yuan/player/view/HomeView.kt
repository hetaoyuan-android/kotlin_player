package com.yuan.player.view

import com.yuan.player.model.HomeItemBean

interface HomeView {
    fun loadSuccess(list: MutableList<HomeItemBean>)
    fun loadMoreSuccess(list: MutableList<HomeItemBean>)
}