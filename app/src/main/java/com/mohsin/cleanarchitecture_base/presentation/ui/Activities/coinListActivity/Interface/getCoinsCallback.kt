package com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity.Interface

import com.mohsin.cryptocurrencyappyt.domain.model.Coin

interface getCoinsCallback {

    fun Success(coins :List<Coin>)
    fun Loading()
    fun Error(Error :String)

}