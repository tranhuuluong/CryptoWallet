package com.luongtran.cryptowallet.util

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow


/**
 * Created by LuongTran on 31/08/2021.
 */
fun <T> Flow<T>.interval(interval: Long, initialDelayMillis: Long = 0) = flatMapLatest {
    flow {
        delay(initialDelayMillis)
        while(true) {
            emit(Unit)
            delay(interval)
        }
    }
}