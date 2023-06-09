package com.example.currencyconverter.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitImplementation {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://data.fixer.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val exchgApi: api by lazy {
        retrofit.create(api::class.java)
    }

}