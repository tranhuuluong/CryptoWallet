package com.luongtran.cryptowallet.di

import com.luongtran.cryptowallet.ui.home.HomeViewModel
import com.luongtran.cryptowallet.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by LuongTran on 31/08/2021.
 */
val fragmentModules = module {
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel() }
}