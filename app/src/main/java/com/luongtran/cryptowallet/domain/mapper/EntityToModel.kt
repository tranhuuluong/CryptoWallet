package com.luongtran.cryptowallet.domain.mapper

import com.luongtran.cryptowallet.data.db.CryptoEntity
import com.luongtran.cryptowallet.domain.model.Crypto

/**
 * Created by LuongTran on 31/08/2021.
 */
fun CryptoEntity.toCrypto() = Crypto(
    baseName = id,
    buyPrice = buyPrice?.toString(),
    sellPrice = sellPrice?.toString(),
    icon = icon,
    name = name
)