package com.luongtran.cryptowallet.ui.home

import androidx.annotation.StringRes
import com.luongtran.cryptowallet.R

/**
 * Created by LuongTran on 03/09/2021.
 */
enum class Page(@StringRes val textResId: Int) {
    BTC(R.string.btc),
    FAVORITES(R.string.favorites)
}