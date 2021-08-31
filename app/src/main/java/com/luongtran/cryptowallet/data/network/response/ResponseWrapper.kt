package com.luongtran.cryptowallet.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 31/08/2021.
 */
open class ResponseWrapper<T>(
    @SerializedName("data")
    val data: T?
)