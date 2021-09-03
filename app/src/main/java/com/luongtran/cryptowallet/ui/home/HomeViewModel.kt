package com.luongtran.cryptowallet.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by LuongTran on 03/09/2021.
 */
class HomeViewModel : ViewModel() {
    private val _page =  MutableLiveData<Page>()
    val page: LiveData<Page> = _page

    fun navigate(page: Page) {
        _page.value = page
    }
}