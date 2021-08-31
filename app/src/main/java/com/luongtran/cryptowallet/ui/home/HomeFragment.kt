package com.luongtran.cryptowallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.luongtran.cryptowallet.databinding.FragmentHomeBinding
import com.luongtran.cryptowallet.ui.BaseFragment

/**
 * Created by LuongTran on 31/08/2021.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
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
}