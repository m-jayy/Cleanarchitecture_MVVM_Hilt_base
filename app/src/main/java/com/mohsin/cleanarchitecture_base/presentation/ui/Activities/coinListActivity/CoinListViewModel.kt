package com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.mohsin.cleanarchitecture_base.presentation.ui.Activities.coinListActivity.CoinListState
import com.mohsin.cryptocurrencyappyt.core.Resource
import com.mohsin.cryptocurrencyappyt.domain.use_case.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState())
    val state = _state.asStateFlow()

    init {
        getCoins()
    }

    private fun getCoins() { // for states
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}