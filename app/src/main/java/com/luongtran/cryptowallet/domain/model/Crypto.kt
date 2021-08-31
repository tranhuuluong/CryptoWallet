package com.luongtran.cryptowallet.domain.model

/**
 * Created by LuongTran on 31/08/2021.
 */
data class Crypto(
    val baseName: String,
    val buyPrice: String?,
    val sellPrice: String?,
    val icon: String?,
    val name: String?
)