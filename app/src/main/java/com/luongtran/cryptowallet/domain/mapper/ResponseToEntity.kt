package com.luongtran.cryptowallet.domain.mapper

import com.luongtran.cryptowallet.data.db.CryptoEntity
import com.luongtran.cryptowallet.data.network.response.CryptoResponse

/**
 * Created by LuongTran on 31/08/2021.
 */
fun CryptoResponse.toCryptoEntity() = CryptoEntity(
    id = base,
    buyPrice = buyPrice,
    sellPrice = sellPrice,
    icon = icon,
    name = name
)