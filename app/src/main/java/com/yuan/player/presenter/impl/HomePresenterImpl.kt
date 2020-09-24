package com.yuan.player.presenter.impl

import com.yuan.player.model.HomeItemBean
import com.yuan.player.presenter.interf.HomePresenter
import com.yuan.player.util.ThreadUtil
import com.yuan.player.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

class HomePresenterImpl(var homeView: HomeView): HomePresenter {
    override fun loadData() {
        val bean = HomeItemBean("张学友", "吻别", "http://www.baidu.com")
        val bean2 = HomeItemBean("刘德华", "忘情水", "http://www.baidu.com")
        val bean3 = HomeItemBean("刀郎", "冲动的惩罚", "http://www.baidu.com")
        val bean4 = HomeItemBean("许嵩", "断桥残雪", "http://www.baidu.com")
        var list: MutableList<HomeItemBean> = ArrayList()
        list.add(bean)
        list.add(bean2)
        list.add(bean3)
        list.add(bean4)
        ThreadUtil.runOnMainThread(Runnable {
            homeView.loadSuccess(list)
        })
    }

    override fun loadMoreData() {
        val bean = HomeItemBean("周杰伦", "稻香", "http://www.baidu.com")
        val bean2 = HomeItemBean("张信哲", "过火", "http://www.baidu.com")
        val bean3 = HomeItemBean("张良", "童话", "http://www.baidu.com")
        var list: MutableList<HomeItemBean> = ArrayList()
        list.add(bean)
        list.add(bean2)
        list.add(bean3)
        ThreadUtil.runOnMainThread(Runnable { homeView.loadMoreSuccess(list)})
    }
}