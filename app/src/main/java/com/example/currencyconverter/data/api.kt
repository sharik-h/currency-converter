package com.example.currencyconverter.data

import com.example.currencyconverter.Model.ExchangeRates
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface api {

    @GET("latest")
    fun getCurrency(
        @Query("access_key")access_key: String,
        @Query("symbols")symbols: String
    ): Response<ExchangeRates>
}