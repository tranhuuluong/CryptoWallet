package com.luongtran.cryptowallet.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import com.luongtran.cryptowallet.data.content.CryptoRepositoryImpl
import com.luongtran.cryptowallet.data.user.UserInfoRepositoryImpl
import com.luongtran.cryptowallet.domain.content.CryptoRepository
import com.luongtran.cryptowallet.domain.content.FetchPriceUseCase
import com.luongtran.cryptowallet.domain.content.GetPriceUseCase
import com.luongtran.cryptowallet.domain.search.SearchUseCase
import com.luongtran.cryptowallet.domain.user.FetchFavoriteUseCase
import com.luongtran.cryptowallet.domain.user.UpdateFavoriteUseCase
import com.luongtran.cryptowallet.domain.user.UserInfoRepository
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
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

    single(qualifier(Qualifiers.USER_DATA_STORE)) {
        PreferenceDataStoreFactory.create(
            produceFile = {
                androidContext().preferencesDataStoreFile("user-data-store")
            }
        )
    }

    single<UserInfoRepository> {
        UserInfoRepositoryImpl(get(qualifier(Qualifiers.USER_DATA_STORE)))
    }

    single {
        GetPriceUseCase(
            cryptoRepository = get(),
            userInfoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single {
        FetchPriceUseCase(
            cryptoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single {
        FetchFavoriteUseCase(
            userInfoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single {
        UpdateFavoriteUseCase(
            userInfoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single {
        SearchUseCase(
            cryptoRepository = get(),
            userInfoRepository = get(),
            ioDispatcher = get(qualifier(Qualifiers.IO_DISPATCHER))
        )
    }

    single(qualifier(Qualifiers.IO_DISPATCHER)) { Dispatchers.IO }

}.plus(listOf(mainActivityModule, fragmentModule, networkModule, databaseModule))

object Qualifiers {
    const val IO_DISPATCHER = "io-dispatcher"
    const val USER_DATA_STORE = "user-data-store"
}