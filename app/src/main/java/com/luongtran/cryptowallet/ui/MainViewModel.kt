package com.luongtran.cryptowallet.ui

import androidx.lifecycle.*
import com.luongtran.cryptowallet.domain.content.FetchPriceUseCase
import com.luongtran.cryptowallet.domain.model.Result
import com.luongtran.cryptowallet.domain.user.FetchFavoriteUseCase
import com.luongtran.cryptowallet.domain.user.UpdateFavoriteUseCase
import com.luongtran.cryptowallet.util.interval
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by LuongTran on 31/08/2021.
 */
class MainViewModel(
    private val fetchPricesUseCase: FetchPriceUseCase,
    private val fetchFavoriteUseCase: FetchFavoriteUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
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

    fun refresh() {
        refreshPrices()
        fetchFavorites()
    }

    private fun refreshPrices() {
        viewModelScope.launch {
            _fetchFlow.emit(Unit)
        }
    }

    fun fetchFavorites() {
        viewModelScope.launch {
            fetchFavoriteUseCase(Unit)
        }
    }

    fun toggleFavorite(id: String, isFavorite: Boolean) {
        viewModelScope.launch {
            updateFavoriteUseCase(id to isFavorite)
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
        const val REFRESH_INTERVAL = 30000L
    }
}