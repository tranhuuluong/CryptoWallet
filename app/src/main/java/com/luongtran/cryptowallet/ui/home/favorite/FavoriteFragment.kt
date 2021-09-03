package com.luongtran.cryptowallet.ui.home.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.cryptowallet.R
import com.luongtran.cryptowallet.databinding.FragmentFavoriteBinding
import com.luongtran.cryptowallet.ui.home.BaseListingFragment
import com.luongtran.cryptowallet.ui.home.HomeViewModel
import com.luongtran.cryptowallet.ui.home.Page
import com.luongtran.cryptowallet.util.addItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by LuongTran on 03/09/2021.
 */
class FavoriteFragment : BaseListingFragment<FragmentFavoriteBinding>() {
    private val viewModel: FavoriteViewModel by viewModel()

    private val homeViewModel: Lazy<HomeViewModel> by lazy {
        requireParentFragment().viewModel()
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        observeData()
    }

    private fun setupUi() {
        binding?.run {
            rvCrypto.run {
                itemAnimator = null
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cryptoAdapter
                addItemDecoration(R.drawable.divider, RecyclerView.VERTICAL)
            }

            tvAddFavorite.setOnClickListener {
                homeViewModel.value.navigate(Page.BTC)
            }
        }
    }

    private fun observeData() {
        viewModel.data.observe(viewLifecycleOwner) { list ->
            binding?.tvAddFavorite?.isVisible = list.isEmpty()
            cryptoAdapter.submitList(list)
        }
    }
}