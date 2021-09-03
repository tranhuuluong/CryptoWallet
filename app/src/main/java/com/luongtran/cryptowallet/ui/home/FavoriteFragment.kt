package com.luongtran.cryptowallet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.luongtran.cryptowallet.databinding.FragmentFavoriteBinding
import com.luongtran.cryptowallet.ui.BaseFragment

/**
 * Created by LuongTran on 03/09/2021.
 */
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }
}