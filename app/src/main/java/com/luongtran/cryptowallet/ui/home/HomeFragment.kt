package com.luongtran.cryptowallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.luongtran.cryptowallet.databinding.FragmentHomeBinding
import com.luongtran.cryptowallet.databinding.ItemTabBinding
import com.luongtran.cryptowallet.ui.BaseFragment
import com.luongtran.cryptowallet.util.round
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

/**
 * Created by LuongTran on 31/08/2021.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: HomeViewModel by viewModel()

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
            ivSearch.setOnClickListener {
                openSearch()
            }

            val pagerAdapter = PagerAdapter(this@HomeFragment)

            viewPager.offscreenPageLimit = 5
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

    private fun observeData() {
        viewModel.page.observe(viewLifecycleOwner) { page ->
            binding?.viewPager?.currentItem = page.ordinal
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