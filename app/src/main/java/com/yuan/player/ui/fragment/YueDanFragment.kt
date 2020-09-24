package com.yuan.player.ui.fragment

import android.view.View
import android.widget.TextView
import com.yuan.player.base.BaseFragment

class YueDanFragment: BaseFragment() {
    override fun initView(): View? {
        val tv = TextView(context)
        tv.text = javaClass.simpleName
        return tv
    }
}