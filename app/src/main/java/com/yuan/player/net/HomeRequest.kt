package com.yuan.player.net

import com.itheima.player.model.bean.HomeItemBean
import com.yuan.player.util.URLProviderUtils

class HomeRequest(type: Int, offset: Int, handler: ResponseHandler<List<HomeItemBean>>)
    :MRequest<List<HomeItemBean>>(type, URLProviderUtils.getHomeUrl(offset, 20), handler) {
}