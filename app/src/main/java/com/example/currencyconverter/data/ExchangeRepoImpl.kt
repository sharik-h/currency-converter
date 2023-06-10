package com.example.currencyconverter.data

import com.example.currencyconverter.Model.ExchangeRates
import javax.inject.Inject

class ExchangeRepoImpl @Inject constructor(
    private val retrofit: api
    ): ExchngeRepo {

    override suspend fun getExchangeRates(key: String): ExchangeRates {
       return retrofit.getCurrency(key)
    }

}