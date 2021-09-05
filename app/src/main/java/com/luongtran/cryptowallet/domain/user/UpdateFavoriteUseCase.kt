package com.luongtran.cryptowallet.domain.user

import com.luongtran.cryptowallet.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by LuongTran on 03/09/2021.
 */
class UpdateFavoriteUseCase(
    private val userInfoRepository: UserInfoRepository,
    ioDispatcher: CoroutineDispatcher
) : UseCase<Pair<String, Boolean>, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: Pair<String, Boolean>) {
        userInfoRepository.updateFavorite(parameters.first, parameters.second)
    }
}