package com.luongtran.cryptowallet.domain.usecase

import com.luongtran.cryptowallet.domain.FlowUseCase
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.domain.model.Result
import com.luongtran.cryptowallet.domain.repository.CryptoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Created by LuongTran on 31/08/2021.
 */
class GetPriceUseCase(
    private val cryptoRepository: CryptoRepository,
    ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<Crypto>>(ioDispatcher) {

    override fun execute(parameters: Unit): Flow<Result<List<Crypto>>> = flow {
        emit(Result.Loading)

        emitAll(cryptoRepository.getPrices()
            .map { Result.Success(it) }
        )
    }
}