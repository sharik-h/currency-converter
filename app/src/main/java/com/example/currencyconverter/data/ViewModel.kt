package com.example.currencyconverter.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.Model.ExchangeRates
import com.example.currencyconverter.Model.Rates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.round

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: ExchangeRepoImpl
) : ViewModel() {

    var selectedFrom = mutableStateOf("")
    var selectedTo = mutableStateOf("")
    var amount =  mutableStateOf<String>("")
    var exchValue =  mutableStateOf(0.0)
    var response: MutableLiveData<ExchangeRates> = MutableLiveData()

    init {
        getExchgRates()
    }

    fun getExchgRates() {
        viewModelScope.launch {
            response.value = repo.getExchangeRates(key = "eb98d1b1a070237be626d1b63578106f")
        }
    }

    fun setValue(name: String, value: String){
        when(name){
            "selectedFrom" -> selectedFrom.value = value
            "selectedTo" -> selectedTo.value = value
            "amount" -> amount.value = value
        }
    }

    fun calculate(){
        val from  = getCurrencyRate(selectedFrom.value, response.value!!.rates) ?: 0.0
        val to  = getCurrencyRate(selectedTo.value, response.value!!.rates) ?: 0.0
        exchValue.value = round((from / to) * amount.value.toInt())
    }

    private fun getCurrencyRate(currency: String, rates: Rates): Double? {
        return when (currency) {
                "USD" -> rates.USD
                "CNY" -> rates.CNY
                "JPY" -> rates.JPY
                "EUR" -> rates.EUR
                "GBP" -> rates.GBP
                "INR" -> rates.INR
                "BRL" -> rates.BRL
                "CAD" -> rates.CAD
                "MXN" -> rates.MXN
                "RUB" -> rates.RUB
                "AUD" -> rates.AUD
                "KRW" -> rates.KRW
                "SAR" -> rates.SAR
                "IDR" -> rates.IDR
                "TRY" -> rates.TRY
                "ARS" -> rates.ARS
                "PLN" -> rates.PLN
                "COP" -> rates.COP
                "THB" -> rates.THB
                "IRR" -> rates.IRR
                "DZD" -> rates.DZD
                "EGP" -> rates.EGP
                "VES" -> rates.VES
                "PEN" -> rates.PEN
                "UAH" -> rates.UAH
                "BDT" -> rates.BDT
                "CZK" -> rates.CZK
                "CLP" -> rates.CLP
                "ZAR" -> rates.ZAR
                "NGN" -> rates.NGN
                "NDK" -> rates.NOK
                "DKK" -> rates.DKK
                "HUF" -> rates.HUF
                "CHF" -> rates.CHF
                "OMR" -> rates.OMR
                "QAR" -> rates.QAR
                else -> 0.0
        }
    }


}