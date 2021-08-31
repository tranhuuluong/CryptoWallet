package com.luongtran.cryptowallet.di

import com.luongtran.cryptowallet.data.CryptoRepositoryImpl
import com.luongtran.cryptowallet.domain.repository.CryptoRepository
import com.luongtran.cryptowallet.domain.usecase.FetchPriceUseCase
import com.luongtran.cryptowallet.domain.usecase.GetPriceUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

/**
 * Created by LuongTran on 31/08/2021.
 */
val appModules = module {
    single<CryptoRepository> {
        CryptoRepositoryImpl(
            cryptoService = get(),
            cryptoDao = get()
        )
    }

    single {
        GetPriceUseCase(
            cryptoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single {
        FetchPriceUseCase(
            cryptoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single(qualifier(Qualifiers.IO_DISPATCHER)) { Dispatchers.IO }

}.plus(listOf(mainActivityModule, fragmentModule, networkModule, databaseModule))

object Qualifiers {
    const val IO_DISPATCHER = "io-dispatcher"
}