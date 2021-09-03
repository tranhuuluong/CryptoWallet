package com.luongtran.cryptowallet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.cryptowallet.databinding.ItemCryptoBinding
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.util.loadCircle

/**
 * Created by LuongTran on 03/09/2021.
 */
class CryptoAdapter(private val listener: OnItemClickListener): ListAdapter<Crypto, CryptoAdapter.CryptoViewHolder>(Crypto.DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CryptoViewHolder(ItemCryptoBinding.inflate(inflater, parent, false), listener)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CryptoViewHolder(
        private val binding: ItemCryptoBinding,
        private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentItem: Crypto? = null

        init {
            binding.tgFavorite.setOnCheckedChangeListener { _, isChecked ->
                currentItem?.let {
                    listener.toggleFavorite(it, isChecked)
                }
            }
        }

        fun bind(crypto: Crypto) {
            currentItem = crypto

            binding.run {
                ivIcon.loadCircle(crypto.icon)
                tvBaseName.text = crypto.baseName
                tvName.text = crypto.name
                tvBuyPrice.text = crypto.buyPrice
                tvSellPrice.text = crypto.sellPrice
                tgFavorite.isChecked = crypto.isFavorite
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(crypto: Crypto)
        fun toggleFavorite(crypto: Crypto, isFavorite: Boolean)
    }
}