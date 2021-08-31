package com.luongtran.cryptowallet.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * Created by LuongTran on 31/08/2021.
 */
data class CryptoResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("counter")
    val counter: String? = null,
    @SerializedName("buy_price")
    val buyPrice: Double? = null,
    @SerializedName("sell_price")
    val sellPrice: Double? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("name")
    val name: String? = null
)