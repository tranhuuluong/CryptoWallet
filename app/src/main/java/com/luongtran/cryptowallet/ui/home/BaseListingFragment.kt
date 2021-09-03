package com.luongtran.cryptowallet.ui.home

import androidx.viewbinding.ViewBinding
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.ui.BaseFragment

/**
 * Created by LuongTran on 03/09/2021.
 */
abstract class BaseListingFragment<T: ViewBinding> : BaseFragment<T>() {
    protected val cryptoAdapter by lazy {
        createCryptoAdapter()
    }

    private fun createCryptoAdapter(): CryptoAdapter {
        return CryptoAdapter(object: CryptoAdapter.OnItemClickListener {
            override fun onItemClick(crypto: Crypto) {
                TODO("Not yet implemented")
            }

            override fun toggleFavorite(crypto: Crypto, isFavorite: Boolean) {
                mainViewModel.toggleFavorite(crypto.baseName, isFavorite)
            }
        })
    }
}