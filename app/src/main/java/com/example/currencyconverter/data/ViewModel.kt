package com.example.currencyconverter.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.Model.ExchangeRates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: ExchangeRepoImpl
) : ViewModel() {

    var selectedFrom = mutableStateOf("")
    var selectedTo = mutableStateOf("")
    var amount =  mutableStateOf("0.00")
    var exchValue =  mutableStateOf("0.00")
    var response: MutableLiveData<ExchangeRates> = MutableLiveData()

    init {
        getExchgRates()
    }

    fun getExchgRates() {
        viewModelScope.launch {
            response.value = repo.getExchangeRates(key = "eb98d1b1a070237be626d1b63578106f")
            printresponse()
        }
    }

    fun printresponse() {
        Log.i("response",response.value.toString())
    }

    fun setValue(name: String, value: String){
        when(name){
            "selectedFrom" -> selectedFrom.value = value
            "selectedTo" -> selectedTo.value = value
            "amount" -> amount.value = value
            "exchValue" -> exchValue.value = value
        }
    }

}