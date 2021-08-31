package com.luongtran.cryptowallet.domain.usecase

import com.luongtran.cryptowallet.domain.UseCase
import com.luongtran.cryptowallet.domain.repository.CryptoRepository
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by LuongTran on 31/08/2021.
 */
class FetchPriceUseCase(
    private val cryptoRepository: CryptoRepository,
    ioDispatcher: CoroutineDispatcher
): UseCase<String, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: String) {
        cryptoRepository.fetchPrices(parameters)
    }
}