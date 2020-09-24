package com.yuan.player.ui.activity

import android.preference.PreferenceManager
import androidx.appcompat.widget.Toolbar
import com.yuan.player.R
import com.yuan.player.base.BaseActivity
import com.yuan.player.util.ToolbarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        initSettingToolbar()
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push", false)
        print("push=$push")
    }
}