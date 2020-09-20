package com.yuan.player.ui.activity

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.yuan.player.R
import com.yuan.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 2000
    }

    override fun onAnimationEnd(view: View?) {
//        startActivity<MainActivity>()
//        finish()
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }
}