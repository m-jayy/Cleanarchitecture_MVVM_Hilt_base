package com.mohsin.cryptocurrencyappyt.domain.use_case

import com.mohsin.cryptocurrencyappyt.core.Resource
import com.mohsin.cryptocurrencyappyt.data.remote.dto.toCoin
import com.mohsin.cryptocurrencyappyt.domain.model.Coin
import com.mohsin.cryptocurrencyappyt.domain.repository.CoinRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRespository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoin().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: Exception) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage))
        } catch (e: IOException) {  // to get internet or connection related expections
            emit(Resource.Error<List<Coin>>("Please Check your Internet"))
        }
    }
}