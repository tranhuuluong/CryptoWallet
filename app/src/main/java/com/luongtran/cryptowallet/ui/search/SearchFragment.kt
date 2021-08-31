package com.luongtran.cryptowallet.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luongtran.cryptowallet.databinding.FragmentSearchBinding
import com.luongtran.cryptowallet.ui.BaseFragment

/**
 * Created by LuongTran on 31/08/2021.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {

    }
}