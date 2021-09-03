package com.luongtran.cryptowallet.ui.home.btc

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.cryptowallet.R
import com.luongtran.cryptowallet.databinding.FragmentBtcBinding
import com.luongtran.cryptowallet.domain.model.Crypto
import com.luongtran.cryptowallet.ui.BaseFragment
import com.luongtran.cryptowallet.ui.home.CryptoAdapter
import com.luongtran.cryptowallet.util.addItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by LuongTran on 03/09/2021.
 */
class BtcFragment : BaseFragment<FragmentBtcBinding>() {
    private val viewModel: BtcViewModel by viewModel()

    private val cryptoAdapter by lazy {
        createCryptoAdapter()
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBtcBinding {
        return FragmentBtcBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        observeData()
    }

    private fun setupUi() {
        binding?.run {
            swipeRefreshLayout.setOnRefreshListener {
                mainViewModel.refresh()
            }

            rvCrypto.run {
                itemAnimator = null
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cryptoAdapter
                addItemDecoration(R.drawable.divider, RecyclerView.VERTICAL)
            }
        }
    }

    private fun observeData() {
        viewModel.data.observe(viewLifecycleOwner) {
            cryptoAdapter.submitList(it)
        }

        mainViewModel.fetchResult.observe(viewLifecycleOwner) { result ->
            binding?.swipeRefreshLayout?.isRefreshing = result.isLoading()
        }
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