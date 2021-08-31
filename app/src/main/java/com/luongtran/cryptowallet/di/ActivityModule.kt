package com.luongtran.cryptowallet.di

import com.luongtran.cryptowallet.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by LuongTran on 31/08/2021.
 */
val mainActivityModule = module {
    viewModel { MainViewModel() }
}