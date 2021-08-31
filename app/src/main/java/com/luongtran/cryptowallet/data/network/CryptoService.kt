package com.luongtran.cryptowallet.data.network

import com.luongtran.cryptowallet.data.network.response.CryptoResponse
import com.luongtran.cryptowallet.data.network.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by LuongTran on 31/08/2021.
 */
interface CryptoService {
    @GET("api/v3/price/all_prices_for_mobile")
    suspend fun getAllPrices(@Query("counter_currency") counter: String): ResponseWrapper<List<CryptoResponse>>
}