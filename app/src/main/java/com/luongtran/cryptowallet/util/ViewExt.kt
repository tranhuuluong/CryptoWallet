package com.luongtran.cryptowallet.util

import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by LuongTran on 03/09/2021.
 */
fun RecyclerView.addItemDecoration(@DrawableRes drawable: Int, orientation: Int) {
    ResourcesCompat.getDrawable(context.resources, drawable, null)?.let {
        val divider = DividerItemDecoration(context, orientation)
        divider.setDrawable(it)
        addItemDecoration(divider)
    }
}