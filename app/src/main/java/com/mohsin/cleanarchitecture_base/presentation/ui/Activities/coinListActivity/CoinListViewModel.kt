package com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.mohsin.cryptocurrencyappyt.core.Resource
import com.mohsin.cryptocurrencyappyt.domain.use_case.GetCoinsUseCase
import com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity.Interface.getCoinsCallback
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel()
{
    fun getCoins(getCoinsCallback: getCoinsCallback) { // we can also implement callback or use states both are good
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    getCoinsCallback.Success(result.data!!)
                }
                is Resource.Error -> {
                    getCoinsCallback.Error(result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    getCoinsCallback.Loading()
                }
            }
        }.launchIn(viewModelScope)
    }
}