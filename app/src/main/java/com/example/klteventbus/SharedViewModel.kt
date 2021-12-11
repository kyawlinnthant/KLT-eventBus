package com.example.klteventbus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private var _countOne = MutableLiveData(0)
    val countOne: LiveData<Int> = _countOne

    private var _countTwo = MutableLiveData(0)
    val countTwo: LiveData<Int> = _countTwo

    fun increaseCountOne() {
        viewModelScope.launch {
            _countOne.value = _countOne.value?.plus(1)
        }
    }

    fun clearCountOne() {
        viewModelScope.launch {
            _countOne.value = 0
        }
    }

    fun increaseCountTwo() {
        viewModelScope.launch {
            _countTwo.value = _countTwo.value?.plus(1)
        }
    }

    fun clearCountTwo() {
        viewModelScope.launch {
            _countTwo.value = 0
        }
    }

}