package com.luongtran.cryptowallet.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.luongtran.cryptowallet.databinding.FragmentHomeBinding
import com.luongtran.cryptowallet.databinding.ItemTabBinding
import com.luongtran.cryptowallet.ui.BaseFragment
import com.luongtran.cryptowallet.util.round
import kotlin.random.Random

/**
 * Created by LuongTran on 31/08/2021.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(mainViewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        Log.d("debugTag", "$mainViewModel")
    }

    private fun setupUI() {
        binding?.run {
            ivSearch.setOnClickListener {
                openSearch()
            }

            val pagerAdapter = PagerAdapter(this@HomeFragment)

            viewPager.offscreenPageLimit = pagerAdapter.itemCount
            viewPager.adapter = pagerAdapter

            TabLayoutMediator(tabLayout, viewPager, true, true) { tab, position ->
                val inflater = LayoutInflater.from(requireContext())
                val tabViewBinding = ItemTabBinding.inflate(inflater)
                tabViewBinding.tvTab.setText(Page.values()[position].textResId)
                tab.customView = tabViewBinding.root
            }.attach()

            tvBalance.text = "${randomBalance().round(2)} $"
        }
    }

    private fun openSearch() {
        val direction = HomeFragmentDirections.openSearch()
        findNavController().navigate(direction)
    }

    private fun randomBalance(): Float {
        return Random.nextFloat() * Random.nextInt(100,10000)
    }

    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }
}