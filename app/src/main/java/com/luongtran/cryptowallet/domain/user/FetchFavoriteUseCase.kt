package com.luongtran.cryptowallet.domain.user

import com.luongtran.cryptowallet.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by LuongTran on 03/09/2021.
 */
class FetchFavoriteUseCase(
    private val userInfoRepository: UserInfoRepository,
    ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: Unit) {
        userInfoRepository.fetchFavorites()
    }
}