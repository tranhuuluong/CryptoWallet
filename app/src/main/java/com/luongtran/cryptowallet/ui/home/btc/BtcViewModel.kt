package com.luongtran.cryptowallet.ui.home.btc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.luongtran.cryptowallet.domain.content.GetPriceUseCase
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.domain.model.Result
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map

/**
 * Created by LuongTran on 31/08/2021.
 */
class BtcViewModel(
    getPricesUseCase: GetPriceUseCase
) : ViewModel() {
    val data = getPricesUseCase(Unit)
        .filterIsInstance<Result.Success<List<Crypto>>>()
        .map { it.data }
        .asLiveData()
}