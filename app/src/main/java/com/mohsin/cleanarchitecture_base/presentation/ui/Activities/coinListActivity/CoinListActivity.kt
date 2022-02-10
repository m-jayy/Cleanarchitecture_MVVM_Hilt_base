package com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.mohsin.cleanarchitecture_base.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CoinListActivity : AppCompatActivity() {
    private val viewModel by viewModels<CoinListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_list)

        viewModel.state.onEach { state ->

            if (state.isLoading) {
                Log.d("Check", "Loading")
            }
            if (state.error.isNotBlank()) {
                Log.d("Check", "Error")
            }
            if (state.coins.isNotEmpty()) {
                Log.d("Check", "${state.coins[0]}")
            }
        }.launchIn(viewModel.viewModelScope)
    }
}