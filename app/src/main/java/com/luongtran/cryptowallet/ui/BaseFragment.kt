package com.luongtran.cryptowallet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created by LuongTran on 31/08/2021.
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {
    protected val mainViewModel: MainViewModel by sharedViewModel()

    protected var binding: T? = null

    private val errorDialog by lazy {
        ConnectionErrorDialog()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = createViewBinding(inflater, container)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?) : T

    protected fun showError() {
        if (errorDialog.dialog == null || errorDialog.dialog?.isShowing == false) {
            errorDialog.show(requireActivity().supportFragmentManager, null)
        }
    }
}