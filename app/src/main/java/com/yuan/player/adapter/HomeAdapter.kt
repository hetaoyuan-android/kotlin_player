package com.yuan.player.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itheima.player.model.bean.HomeItemBean
import com.yuan.player.widget.HomeItemView
import com.yuan.player.widget.LoadMoreView
import java.util.ArrayList

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {


    private var list = ArrayList<HomeItemBean>()

    fun updateList(list:List<HomeItemBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun updateMoreList(list:List<HomeItemBean>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }



    class HomeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return if (viewType == 1) {
            HomeHolder(LoadMoreView(parent.context))
        } else {
            HomeHolder(HomeItemView(parent.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) {
            1
        } else {
            0
        }

    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if (position == list.size) return
        val data = list[position]
        //条目view
        val itemView = holder.itemView as HomeItemView
        itemView.setData(data)

    }
}