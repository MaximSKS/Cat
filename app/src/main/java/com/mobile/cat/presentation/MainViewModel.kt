package com.mobile.cat.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel(){

    private val _mutableState = MutableStateFlow("")
    val state = _mutableState.asStateFlow()


}