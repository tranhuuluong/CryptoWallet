package com.luongtran.cryptowallet.domain.user

import kotlinx.coroutines.flow.Flow

/**
 * Created by LuongTran on 03/09/2021.
 */
interface UserInfoRepository {
    suspend fun fetchFavorites()

    suspend fun getFavorites(): Flow<Set<String>>

    suspend fun updateFavorite(id: String, isFavorite: Boolean)
}