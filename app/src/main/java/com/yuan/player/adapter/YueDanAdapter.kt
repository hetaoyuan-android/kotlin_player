package com.yuan.player.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itheima.player.model.bean.YueDanBean
import com.yuan.player.widget.LoadMoreView
import com.yuan.player.widget.YueDanItemView

class YueDanAdapter: RecyclerView.Adapter<YueDanAdapter.YueDanHolder>(){

    private var list = ArrayList<YueDanBean.PlayListsBean>()
    fun updateList(list: ArrayList<YueDanBean.PlayListsBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun updateMoreList(list: ArrayList<YueDanBean.PlayListsBean>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class YueDanHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        return if (viewType == 1) {
            YueDanHolder(LoadMoreView(parent.context))
        } else{
            YueDanHolder(YueDanItemView(parent.context))
        }

    }

    override fun getItemCount(): Int {
        return 20 + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) {
            1
        } else{
            0
        }
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
//        if (position == list.size){
//            return
//        }
//        val data = list[position]
//        val itemView = holder?.itemView as YueDanItemView
//        itemView.setData(data)
    }
}