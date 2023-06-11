package com.example.currencyconverter.MainPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconverter.data.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun conversionPage(viewModel: MainViewModel) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            text = "Exchange Rate",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = viewModel.exchValue.value.toString(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Amount",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left
        )
        OutlinedTextField(
            value = viewModel.amount.value.toString(),
            onValueChange = { viewModel.setValue("amount",value =  it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "0.00") }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.fillMaxWidth()) {
            CurrencySelector(
                modifier = Modifier.weight(0.5f),
                fromOrTo = "From",
                selectedValue = { viewModel.setValue("selectedFrom", it) }
            )
            CurrencySelector(
                modifier = Modifier.weight(0.5f),
                fromOrTo = "To",
                selectedValue = { viewModel.setValue("selectedTo",it) },
            )
        }
        Button(
            onClick = { viewModel.calculate() },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "CONVERT", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }

}