package com.mohsin.cryptocurrencyappyt.data.di

import com.mohsin.cryptocurrencyappyt.core.Constants.BASE_URL
import com.mohsin.cryptocurrencyappyt.data.remote.ApiDefination
import com.mohsin.cryptocurrencyappyt.data.repository.CoinRespositoryImpl
import com.mohsin.cryptocurrencyappyt.domain.repository.CoinRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiDefincation(): ApiDefination {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiDefination::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiDefination): CoinRespository {
        return CoinRespositoryImpl(api)
    }
}