package com.yuan.player.ui.fragment

import android.graphics.Color
import android.graphics.Color.RED
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yuan.player.R
import com.yuan.player.adapter.HomeAdapter
import com.yuan.player.base.BaseFragment
import com.yuan.player.model.HomeItemBean
import com.yuan.player.presenter.impl.HomePresenterImpl
import com.yuan.player.util.ThreadUtil
import com.yuan.player.util.URLProviderUtils
import com.yuan.player.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

class HomeFragment: BaseFragment(), HomeView {

    val adapter by lazy { HomeAdapter()  }
    val presenter by lazy { HomePresenterImpl(this) }

    override fun initView(): View? {
       return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        //刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        //刷新监听
        refreshLayout.setOnRefreshListener {

            presenter.loadData()
            //刷新监听
            val bean = HomeItemBean("张碧晨", "年轮", "http://www.baidu.com")
            val bean2 = HomeItemBean("毛不易", "梅香如故", "http://www.baidu.com")
            val bean3 = HomeItemBean("周深", "大鱼海棠", "http://www.baidu.com")
            val bean4 = HomeItemBean("张杰", "天下", "http://www.baidu.com")
            var list: MutableList<HomeItemBean> = ArrayList()
            list.add(bean)
            list.add(bean2)
            list.add(bean3)
            list.add(bean4)
            ThreadUtil.runOnMainThread(Runnable { adapter.updateList(list)
                refreshLayout.isRefreshing = false})
        }
        //监听列表滑动
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                /*when(newState) {
                    RecyclerView.SCROLL_STATE_IDLE ->{}
                    RecyclerView.SCROLL_STATE_DRAGGING ->{}
                    RecyclerView.SCROLL_STATE_SETTLING ->{}
                }*/
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //是否是最后一条
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {

                            presenter.loadMoreData()


                        }
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    override fun initData() {

        presenter.loadData()

//        loadData()

    }

    private fun loadData() {
        val path = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                myToast("获取数据失败")
            }

            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                val result = response?.body?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object :
                    TypeToken<List<HomeItemBean>>(){}.type)
                ThreadUtil.runOnMainThread(Runnable { adapter.updateList(list) })
                Log.e("TAG", result)
            }

        })
    }

    override fun loadSuccess(list: MutableList<HomeItemBean>) {
        adapter.updateList(list)
        refreshLayout.isRefreshing = false
    }

    override fun loadMoreSuccess(list: MutableList<HomeItemBean>) {
        adapter.updateMoreList(list)
        refreshLayout.isRefreshing = false
    }
}