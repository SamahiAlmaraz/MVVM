package com.example.cats.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cats.domain.model.CatFactState
import com.example.cats.domain.model.Fact
import com.example.cats.domain.useCase.GetCatRandomFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatRandomFactUseCase: GetCatRandomFactUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<CatFactState>(CatFactState.Init)
    val uiState: StateFlow<CatFactState> = _uiState

init {
    getCatFact()
}

    fun getCatFact() = viewModelScope.launch {
        val uiState = getCatRandomFactUseCase().first()
        withContext(Dispatchers.IO) {
            when (uiState) {
                is CatFactState.Init -> notifyInitState()
                is CatFactState.Loading -> notifyLoadingState()
                is CatFactState.CatFactData -> notifyCatFactState(uiState.fact)
                is CatFactState.Error -> notifyErrorState(uiState.error)
            }
        }
    }

    private fun notifyInitState() {
        _uiState.value=CatFactState.Init
    }

    private fun notifyLoadingState() {
        _uiState.value=CatFactState.Loading
    }

    private fun notifyCatFactState(fact: Fact) {
        _uiState.value=CatFactState.CatFactData(fact)
    }

    private fun notifyErrorState(error: Throwable) {
        _uiState.value=CatFactState.Error(error)
    }

}