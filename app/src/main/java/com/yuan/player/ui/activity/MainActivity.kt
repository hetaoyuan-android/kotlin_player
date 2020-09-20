package com.yuan.player.ui.activity

import androidx.appcompat.widget.Toolbar
import com.yuan.player.R
import com.yuan.player.base.BaseActivity
import com.yuan.player.util.ToolbarManager
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolbar()
    }
}