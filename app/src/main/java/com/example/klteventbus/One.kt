package com.example.klteventbus

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.klteventbus.MainActivity.Companion.NAV_ITEM_TYPE_ONE
import com.example.klteventbus.MainActivity.Companion.NAV_ITEM_TYPE_TWO

class One : Fragment(R.layout.one_layout) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().findViewById<Button>(R.id.btn_one_add)?.setOnClickListener {
            (activity as MainActivity).addBadge(1, NAV_ITEM_TYPE_TWO)
        }

        requireActivity().findViewById<Button>(R.id.btn_one_clear)?.setOnClickListener {
            (activity as MainActivity).clearBadge(NAV_ITEM_TYPE_ONE)
        }

    }
}