package com.example.currencyconverter.data

import com.example.currencyconverter.Model.ExchangeRates

interface ExchngeRepo {
    suspend fun getExchangeRates(key: String): ExchangeRates
}