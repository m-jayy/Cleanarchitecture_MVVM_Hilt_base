package com.mohsin.cryptocurrencyappyt.data.remote

import com.mohsin.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.mohsin.cryptocurrencyappyt.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDefination {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}