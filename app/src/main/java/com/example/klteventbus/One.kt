package com.example.klteventbus

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.klteventbus.MainActivity.Companion.NAV_ITEM_TYPE_ONE
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class One : Fragment(R.layout.one_layout) {

    private val oneViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        oneViewModel.countOne.observe(viewLifecycleOwner) {
            (activity as MainActivity).checkBadge(it,NAV_ITEM_TYPE_ONE)
        }

        requireActivity().findViewById<Button>(R.id.btn_one_add)?.setOnClickListener {
            oneViewModel.increaseCountTwo()
        }

        requireActivity().findViewById<Button>(R.id.btn_one_clear)?.setOnClickListener {
            oneViewModel.clearCountOne()
        }

    }
}