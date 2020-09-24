package com.yuan.player.util

import android.content.Intent
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.yuan.player.R
import com.yuan.player.ui.activity.SettingActivity

interface ToolbarManager {
    val toolbar:Toolbar

    /**
     * 初始化主界面的toolbar
     */
    fun initMainToolbar() {
        toolbar.title = "小猪影音"
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener { item ->
            if (item != null) {
                when(item.itemId) {
                    R.id.setting ->{
                        toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
                    }
                }
            }
            true
        }
    }

    /**
     * 处理设置界面的toolbar
     */
    fun initSettingToolbar() {
        toolbar.title = "设置"
    }
}