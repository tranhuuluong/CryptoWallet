package com.luongtran.cryptowallet.domain.search

import com.luongtran.cryptowallet.domain.FlowUseCase
import com.luongtran.cryptowallet.domain.content.CryptoRepository
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.domain.model.Result
import com.luongtran.cryptowallet.domain.user.UserInfoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

/**
 * Created by LuongTran on 04/09/2021.
 */
class SearchUseCase(
    private val cryptoRepository: CryptoRepository,
    private val userInfoRepository: UserInfoRepository,
    ioDispatcher: CoroutineDispatcher,
) : FlowUseCase<String, List<Crypto>>(ioDispatcher) {
    override fun execute(parameters: String): Flow<Result<List<Crypto>>> = flow {
        emit(Result.Loading)

        val dataFlow = combine(cryptoRepository.search(parameters), userInfoRepository.getFavorites()) { data, favourites -> data to favourites }
            .map { (data, favourites) ->
                data.map { crypto ->
                    crypto.copy(isFavorite = favourites.contains(crypto.baseName))
                }
            }

        emitAll(
            dataFlow
                .map { Result.Success(it) }
        )
    }
}