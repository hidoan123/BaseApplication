package com.example.baseapplication.main.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState: StateFlow<HomeUIState> = _uiState


}


sealed class HomeUIState {
    object Loading : HomeUIState()
    data class Success(val data: String) : HomeUIState()
    data class Error(val message: String) : HomeUIState()
}

