package com.yuan.player.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itheima.player.model.bean.HomeItemBean
import com.itheima.player.model.bean.YueDanBean
import com.yuan.player.R
import com.yuan.player.adapter.YueDanAdapter
import com.yuan.player.base.BaseFragment
import com.yuan.player.presenter.impl.YueDanPresenterImpl
import com.yuan.player.view.YueDanView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_yuedan.*

class YueDanFragment: BaseFragment(), YueDanView {


    private val adapter by lazy { YueDanAdapter() }
    private val presenter by lazy { YueDanPresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_yuedan,null)
    }

    override fun initListener() {
        recycleViewYue.layoutManager = LinearLayoutManager(context)
        var list: MutableList<YueDanBean.PlayListsBean> = ArrayList()
        recycleViewYue.adapter = adapter
        refreshLayoutYue.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        refreshLayoutYue.setOnRefreshListener {
            presenter.loadData()
            refreshLayoutYue.isRefreshing = false
        }

        //滑动监听是不是需要加载更多
        recycleViewYue.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //是否是最后一条
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {

                            presenter.loadMore(adapter.itemCount - 1)


                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        presenter.loadData()
    }

    override fun onError(message: String?) {
        refreshLayoutYue.isRefreshing = false
    }

    override fun loadSuccess(response: YueDanBean?) {
        refreshLayoutYue.isRefreshing = false
        //刷新adapter
//        adapter.updateList(response?.playLists as ArrayList<YueDanBean.PlayListsBean>)
    }

    override fun loadMoreSuccess(response: YueDanBean?) {
        refreshLayoutYue.isRefreshing = false
//        adapter.updateMoreList(response?.playLists as ArrayList<YueDanBean.PlayListsBean>)
    }
}