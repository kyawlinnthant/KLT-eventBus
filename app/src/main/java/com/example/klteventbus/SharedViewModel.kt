package com.example.klteventbus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {


    private lateinit var _countOne: Flow<Int>
    val countOne: Flow<Int> get() = _countOne

    private lateinit var _countTwo: Flow<Int>
    val countTwo: Flow<Int> get() = _countTwo

    init {
        setInitialOne()
        setInitialTwo()
    }

    private fun setInitialOne() {
        viewModelScope.launch {
            _countOne = flow {
                emit(0)
            }

        }
    }

    private fun setInitialTwo() {
        _countTwo = flow {
            emit(0)
        }
    }


    fun increaseCountOne() {
        viewModelScope.launch {
            _countOne = flow {
                emit( 1)
            }
        }
    }

    fun clearCountOne() {
        setInitialOne()
    }

    fun increaseCountTwo() {
        viewModelScope.launch {
            _countTwo = flow {
                emit(+1)
            }
        }
    }

    fun clearCountTwo() {
        setInitialTwo()
    }

}