package com.luongtran.cryptowallet.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luongtran.cryptowallet.R
import com.luongtran.cryptowallet.databinding.FragmentSearchBinding
import com.luongtran.cryptowallet.ui.home.BaseListingFragment
import com.luongtran.cryptowallet.util.addItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by LuongTran on 31/08/2021.
 */
class SearchFragment : BaseListingFragment<FragmentSearchBinding>() {
    private val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mainViewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeData()
    }

    private fun setupUI() {
        binding?.run {
            tvCancel.setOnClickListener {
                findNavController().navigateUp()
            }

            ivClearSearch.setOnClickListener {
                etSearch.text = null
            }

            etSearch.run {
                doAfterTextChanged { keyword ->
                    ivClearSearch.isGone = keyword.isNullOrEmpty()
                    viewModel.search(keyword?.toString() ?: "")
                }

                setOnFocusChangeListener { v, hasFocus ->
                    if (hasFocus) {
                        showKeyboard(v)
                    }
                }

                requestFocus()
            }

            rvCrypto.run {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cryptoAdapter
                addItemDecoration(R.drawable.divider, RecyclerView.VERTICAL)
            }

            swipeRefreshLayout.setOnRefreshListener {
                mainViewModel.refresh()
            }
        }
    }

    private fun observeData() {
        viewModel.data.observe(viewLifecycleOwner) {
            binding?.tvNoResults?.isVisible = it.isNullOrEmpty()
            cryptoAdapter.submitList(it)
        }

        mainViewModel.fetchResult.observe(viewLifecycleOwner) {
            binding?.swipeRefreshLayout?.isRefreshing = it.isLoading()

            if (it.isError()) {
                showError()
            }
        }
    }

    override fun onPause() {
        dismissKeyboard(binding!!.etSearch)
        super.onPause()
    }

    private fun showKeyboard(view: View) {
        ViewCompat.getWindowInsetsController(view)?.show(WindowInsetsCompat.Type.ime())
    }

    private fun dismissKeyboard(view: View) {
        ViewCompat.getWindowInsetsController(view)?.hide(WindowInsetsCompat.Type.ime())
    }

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }
}