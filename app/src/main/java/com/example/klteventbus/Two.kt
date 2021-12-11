package com.example.klteventbus

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Two : Fragment(R.layout.two_layout) {

    private val twoViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        twoViewModel.countTwo.observe(viewLifecycleOwner) {
            (activity as MainActivity).checkBadge(it, MainActivity.NAV_ITEM_TYPE_TWO)
        }

        requireActivity().findViewById<Button>(R.id.btn_two_add).setOnClickListener {
            twoViewModel.increaseCountOne()
        }
        requireActivity().findViewById<Button>(R.id.btn_two_clear).setOnClickListener {
            twoViewModel.clearCountTwo()
        }

    }
}