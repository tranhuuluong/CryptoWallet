package com.luongtran.cryptowallet.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.luongtran.cryptowallet.R
import com.luongtran.cryptowallet.databinding.DialogConnectionErrorBinding

/**
 * Created by LuongTran on 04/09/2021.
 */
class ConnectionErrorDialog : AppCompatDialogFragment() {

    private lateinit var binding: DialogConnectionErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogConnectionErrorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btGotIt.setOnClickListener {
            dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window?.setBackgroundDrawableResource(R.drawable.bg_connection_error_dialog)
        }
    }
}