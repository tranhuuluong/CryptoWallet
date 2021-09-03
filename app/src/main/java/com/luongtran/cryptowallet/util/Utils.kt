package com.luongtran.cryptowallet.util

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by LuongTran on 03/09/2021.
 */
fun Float.round(number: Int): Float {
    return BigDecimal(this.toDouble()).setScale(number, RoundingMode.HALF_EVEN).toFloat()
}