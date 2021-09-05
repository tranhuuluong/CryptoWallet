package com.luongtran.cryptowallet.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.luongtran.cryptowallet.ui.home.btc.BtcFragment
import com.luongtran.cryptowallet.ui.home.favorite.FavoriteFragment

/**
 * Created by LuongTran on 03/09/2021.
 */
class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = Page.values().size

    override fun createFragment(position: Int): Fragment {
        return when (Page.values()[position]) {
            Page.BTC -> BtcFragment()
            Page.FAVORITES -> FavoriteFragment()
        }
    }
}