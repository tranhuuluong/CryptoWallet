package com.luongtran.cryptowallet.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.domain.model.Result
import com.luongtran.cryptowallet.domain.search.SearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * Created by LuongTran on 31/08/2021.
 */
class SearchViewModel(
    searchUseCase: SearchUseCase
) : ViewModel() {
    private val searchFlow = MutableStateFlow(String())

    val data = searchFlow
        .flatMapLatest { keyword -> searchUseCase(keyword) }
        .filterIsInstance<Result.Success<List<Crypto>>>()
        .map { it.data }
        .asLiveData()

    fun search(keyword: String) {
        viewModelScope.launch {
            searchFlow.emit(keyword)
        }
    }
}