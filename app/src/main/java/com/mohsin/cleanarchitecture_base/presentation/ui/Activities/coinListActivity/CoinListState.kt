package com.mohsin.cleanarchitecture_base.presentation.ui.Activities.coinListActivity

import com.mohsin.cryptocurrencyappyt.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)
