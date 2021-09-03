package com.luongtran.cryptowallet.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * Created by LuongTran on 03/09/2021.
 */
private fun createRequestOption(): RequestOptions = RequestOptions()
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .centerInside()

private fun ImageView.loadWithRequestOption(url: String?, requestOptions: RequestOptions) {
    if (url.isNullOrBlank()) {
        return
    }

    Glide.with(this)
        .load(url)
        .apply(requestOptions)
        .into(this)
}

fun ImageView.loadCircle(url: String?) {
    val requestOptions = createRequestOption().circleCrop()
    loadWithRequestOption(url, requestOptions)
}