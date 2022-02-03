package com.mohsin.cryptocurrencyappyt.data.repository

import com.mohsin.cryptocurrencyappyt.data.remote.ApiDefination
import com.mohsin.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.mohsin.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.mohsin.cryptocurrencyappyt.domain.repository.CoinRespository
import javax.inject.Inject

class CoinRespositoryImpl @Inject constructor(
    private val api: ApiDefination
) : CoinRespository {
    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}