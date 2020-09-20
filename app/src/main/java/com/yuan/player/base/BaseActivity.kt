package com.yuan.player.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yuan.player.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 获取布局Id
     */
    abstract fun getLayoutId() : Int

    protected open fun initListener() {
    }

    protected open fun initData() {}

    protected fun myToast(msg: String) {
        runOnUiThread{toast(msg)}
    }

    /**
     * 开启activity并且结束当前界面
     */
    inline fun <reified T: BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }
}