package com.yuan.player.net

interface ResponseHandler<RESPONSE> {
    fun onError(type:Int,msg:String?)
    fun onSuccess(type:Int,result:RESPONSE)
}