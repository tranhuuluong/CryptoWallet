package com.luongtran.cryptowallet.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.luongtran.cryptowallet.databinding.FragmentHomeBinding
import com.luongtran.cryptowallet.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by LuongTran on 31/08/2021.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        Log.d("debugTag", "$viewModel")
    }

    private fun setupUI() {
        binding?.run {
            btOpenSearch.setOnClickListener {
                openSearch()
            }
        }
    }

    private fun openSearch() {
        val direction = HomeFragmentDirections.openSearch()
        findNavController().navigate(direction)
    }

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }
}