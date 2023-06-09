package com.example.currencyconverter.Model

data class ExchangeRates(
    val base: String,
    val date: String,
    val rates: List<Pair<String, Double>>,
    val success: Boolean,
    val timestamp: Int
)