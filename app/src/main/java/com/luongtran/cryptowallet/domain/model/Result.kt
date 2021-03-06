package com.luongtran.cryptowallet.domain.model

/**
 * Created by LuongTran on 31/08/2021.
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Throwable): Result<Nothing>()
    object Loading : Result<Nothing>()

    fun isLoading(): Boolean = this is Loading

    fun isError(): Boolean = this is Error

    fun isSuccess(): Boolean = this is Success
}