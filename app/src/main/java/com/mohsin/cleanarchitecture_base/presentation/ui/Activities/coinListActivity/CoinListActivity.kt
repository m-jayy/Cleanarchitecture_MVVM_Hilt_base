package com.mohsin.cleanarchitecture_base.presentation.ui.Activities.coinListActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohsin.cleanarchitecture_base.databinding.ActivityCoinListBinding
import com.mohsin.cleanarchitecture_base.domain.helpers.Coroutines
import com.mohsin.cleanarchitecture_base.presentation.ui.Activities.coinListActivity.adapters.CoinListAdapter
import com.mohsin.cryptocurrencyappyt.domain.model.Coin
import com.mohsin.cryptocurrencyappyt.presentation.ui.Activities.coinListActivity.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CoinListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoinListBinding


    private val viewModel by viewModels<CoinListViewModel>()

    private var coinAdapter: CoinListAdapter? = null
    private var coinListData: ArrayList<Coin?> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoinListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coinListData.let {
            binding.rvDashboardCoin.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            coinAdapter = CoinListAdapter(it)
            binding.rvDashboardCoin.adapter = coinAdapter
        }

        viewModel.state.onEach { it ->
            if (it.error.isEmpty()) {
                if (it.isLoading) {
                    Coroutines.main {
                        binding.shimmer.startShimmer()
                    }
                } else {
                    binding.shimmer.stopShimmer()
                    binding.shimmer.visibility = View.GONE
                    binding.rvDashboardCoin.visibility = View.VISIBLE
                    coinListData.addAll(it.coins)
                    coinAdapter?.notifyDataSetChanged()
                }
            } else {
                Toast.makeText(this, "${it.error}", Toast.LENGTH_SHORT).show()
            }
        }.launchIn(viewModel.viewModelScope)
    }
}