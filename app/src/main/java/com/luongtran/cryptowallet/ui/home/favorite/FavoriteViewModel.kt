package com.luongtran.cryptowallet.ui.home.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.luongtran.cryptowallet.domain.content.GetPriceUseCase
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.domain.model.Result
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map

/**
 * Created by LuongTran on 03/09/2021.
 */
class FavoriteViewModel(
    getPriceUseCase: GetPriceUseCase
) : ViewModel() {
    val data = getPriceUseCase(Unit)
        .filterIsInstance<Result.Success<List<Crypto>>>()
        .map { it.data.filter { crypto -> crypto.isFavorite } }
        .asLiveData()
}