package com.luongtran.cryptowallet.domain.model

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by LuongTran on 31/08/2021.
 */
data class Crypto(
    val baseName: String,
    val buyPrice: String,
    val sellPrice: String,
    val icon: String?,
    val name: String?,
    val isFavorite: Boolean
) {
    companion object {
        val DIFF_UTIL = object: DiffUtil.ItemCallback<Crypto>() {
            override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
                return oldItem.baseName == newItem.baseName
            }

            override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
                return oldItem == newItem
            }
        }
    }
}