package com.example.klteventbus

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Two : Fragment(R.layout.two_layout) {

    private val twoViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(twoViewModel) {

            viewLifecycleOwner.lifecycleScope.launch {

                countTwo.collect {
                    (activity as MainActivity).checkBadge(
                        it,
                        MainActivity.NAV_ITEM_TYPE_TWO
                    )
                }

            }
            requireActivity().findViewById<Button>(R.id.btn_two_add).setOnClickListener {
                this.increaseCountOne()
            }
            requireActivity().findViewById<Button>(R.id.btn_two_clear).setOnClickListener {
                this.clearCountTwo()
            }

        }

    }
}