package com.luongtran.cryptowallet.ui

import androidx.lifecycle.*
import com.luongtran.cryptowallet.domain.usecase.FetchPriceUseCase
import com.luongtran.cryptowallet.util.interval
import com.luongtran.cryptowallet.domain.model.Result
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by LuongTran on 31/08/2021.
 */
class MainViewModel(
    private val fetchPricesUseCase: FetchPriceUseCase
) : ViewModel(), LifecycleObserver {
    private var shouldRefresh = false

    private val _fetchFlow = MutableSharedFlow<Unit>()

    private val refreshPriceFlow = _fetchFlow
        .interval(REFRESH_INTERVAL)
        .onEach {
            if (shouldRefresh) {
                fetchPricesUseCase(DEFAULT_COUNTER)
            }
        }

    val fetchResult = _fetchFlow.flatMapLatest {
        flow {
            emit(Result.Loading)

            fetchPricesUseCase(DEFAULT_COUNTER)

            emit(Result.Success(Unit))
        }.catch { e ->
            emit(Result.Error(e))
        }
    }.asLiveData()

    fun refreshPrices() {
        viewModelScope.launch {
            _fetchFlow.emit(Unit)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        shouldRefresh = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        shouldRefresh = true
        refreshPrices()
    }

    init {
        refreshPriceFlow.launchIn(viewModelScope)
    }

    companion object {
        const val DEFAULT_COUNTER = "USD"
        const val REFRESH_INTERVAL = 5000L
    }
}