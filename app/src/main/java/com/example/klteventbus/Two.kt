package com.example.klteventbus

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.klteventbus.MainActivity.Companion.NAV_ITEM_TYPE_ONE
import com.example.klteventbus.MainActivity.Companion.NAV_ITEM_TYPE_TWO

class Two : Fragment(R.layout.two_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<Button>(R.id.btn_two_add).setOnClickListener {
            (activity as MainActivity).addBadge(1, NAV_ITEM_TYPE_ONE)
        }
        requireActivity().findViewById<Button>(R.id.btn_two_clear).setOnClickListener {
            (activity as MainActivity).clearBadge(NAV_ITEM_TYPE_TWO)
        }

    }
}