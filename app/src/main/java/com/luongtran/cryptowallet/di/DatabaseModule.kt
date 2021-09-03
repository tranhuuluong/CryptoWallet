package com.luongtran.cryptowallet.di

import com.luongtran.cryptowallet.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by LuongTran on 31/08/2021.
 */
val databaseModule = module {
    single { AppDatabase.buildDatabase(androidContext()) }

    single { get<AppDatabase>().cryptoDao() }
}