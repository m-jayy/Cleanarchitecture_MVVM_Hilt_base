package com.mohsin.cryptocurrencyappyt.domain.repository

import com.mohsin.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.mohsin.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRespository {

    suspend fun getCoin(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}