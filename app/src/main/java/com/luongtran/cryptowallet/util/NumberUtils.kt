package com.luongtran.cryptowallet.util

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Created by LuongTran on 03/09/2021.
 */
fun Float.round(number: Int): Float {
    return BigDecimal(this.toDouble()).setScale(number, RoundingMode.HALF_EVEN).toFloat()
}

fun Double.toCurrency(): String {
    return DecimalFormat("###,###,##0.00").format(this)
}