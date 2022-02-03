package com.mohsin.cryptocurrencyappyt.domain.use_case

import com.mohsin.cryptocurrencyappyt.core.Resource
import com.mohsin.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.mohsin.cryptocurrencyappyt.domain.model.CoinDetail
import com.mohsin.cryptocurrencyappyt.domain.repository.CoinRespository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRespository
) {
    operator fun invoke(coinID :String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinID).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: Exception) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage))
        } catch (e: IOException) {  // to get internet or connection related expections
            emit(Resource.Error<CoinDetail>("Please Check your Internet"))
        }
    }
}