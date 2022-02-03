package com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mohsin.cleanarchitecture_base.R
import com.mohsin.cryptocurrencyappyt.domain.model.Coin
import com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity.Interface.getCoinsCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinListActivity : AppCompatActivity(),getCoinsCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)

         val viewModel by viewModels<CoinListViewModel>()
        viewModel.getCoins(this)

    }

    override fun Success(coins: List<Coin>) {
        Log.d("Check","Success Case")
    }

    override fun Loading() {
        Log.d("Check","Loading")
    }

    override fun Error(Error: String) {
        Log.d("Check","Error")
    }
}