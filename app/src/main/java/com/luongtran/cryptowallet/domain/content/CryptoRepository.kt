package com.luongtran.cryptowallet.domain.content

import com.luongtran.cryptowallet.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

/**
 * Created by LuongTran on 31/08/2021.
 */
interface CryptoRepository {
    suspend fun fetchPrices(counter: String)

    fun getPrices(): Flow<List<Crypto>>
}