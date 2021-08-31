package com.luongtran.cryptowallet.di

import com.luongtran.cryptowallet.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by LuongTran on 31/08/2021.
 */
val databaseModule = module {
    single { AppDatabase.buildDatabase(androidApplication()) }

    single { get<AppDatabase>().cryptoDao() }
}