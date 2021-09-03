package com.luongtran.cryptowallet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.luongtran.cryptowallet.databinding.FragmentBtcBinding
import com.luongtran.cryptowallet.ui.BaseFragment

/**
 * Created by LuongTran on 03/09/2021.
 */
class BtcFragment : BaseFragment<FragmentBtcBinding>() {
    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBtcBinding {
        return FragmentBtcBinding.inflate(inflater, container, false)
    }
}