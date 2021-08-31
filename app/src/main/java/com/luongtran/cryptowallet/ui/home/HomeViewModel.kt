package com.luongtran.cryptowallet.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.luongtran.cryptowallet.domain.usecase.GetPriceUseCase

/**
 * Created by LuongTran on 31/08/2021.
 */
class HomeViewModel(
    getPricesUseCase: GetPriceUseCase
) : ViewModel() {
    val data = getPricesUseCase(Unit).asLiveData()
}