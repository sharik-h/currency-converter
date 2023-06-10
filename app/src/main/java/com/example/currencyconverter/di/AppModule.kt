package com.example.currencyconverter.di

import com.example.currencyconverter.data.ExchangeRepoImpl
import com.example.currencyconverter.data.api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApi(): api {
        return Retrofit.Builder()
            .baseUrl("http://data.fixer.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(api: api): ExchangeRepoImpl {
        return ExchangeRepoImpl(api)
    }
}