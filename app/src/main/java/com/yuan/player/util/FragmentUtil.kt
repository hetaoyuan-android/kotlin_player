package com.yuan.player.util

import com.yuan.player.R
import com.yuan.player.base.BaseFragment
import com.yuan.player.ui.fragment.HomeFragment
import com.yuan.player.ui.fragment.MvFragment
import com.yuan.player.ui.fragment.VBangFragment
import com.yuan.player.ui.fragment.YueDanFragment

class FragmentUtil private constructor(){

    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vBangFragment by lazy { VBangFragment() }
    val yueDanFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * 根据tabId得到对应的fragment
     */
    fun getFragment(tabId: Int): BaseFragment? {
        when(tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mvFragment
            R.id.tab_vbang -> return vBangFragment
            R.id.tab_yuedan -> return yueDanFragment
        }
        return null
    }
}