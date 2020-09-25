package com.yuan.player.presenter.impl

import com.itheima.player.model.bean.YueDanBean
import com.yuan.player.net.ResponseHandler
import com.yuan.player.net.YueDanRequest
import com.yuan.player.presenter.interf.YueDanPresenter
import com.yuan.player.view.YueDanView

class YueDanPresenterImpl(var yueDanView: YueDanView): YueDanPresenter,
    ResponseHandler<YueDanBean> {
    override fun loadData() {
//        YueDanRequest(YueDanPresenter.TYPE_INIT_OR_REFRESH, 0, this).excute()
    }

    override fun loadMore(offset: Int) {
        YueDanRequest(YueDanPresenter.TYPE_LOAD_MORE, offset, this).excute()
    }

    override fun onError(type: Int, msg: String?) {
        yueDanView.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        if (type== YueDanPresenter.TYPE_INIT_OR_REFRESH) {
            yueDanView.loadSuccess(result)
        } else if (type == YueDanPresenter.TYPE_LOAD_MORE){
            yueDanView.loadMoreSuccess(result)
        }
    }
}