package com.luongtran.cryptowallet.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luongtran.cryptowallet.databinding.FragmentSearchBinding
import com.luongtran.cryptowallet.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by LuongTran on 31/08/2021.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        Log.d("debugTag", "$viewModel")
    }

    private fun setupUI() {

    }

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }
}