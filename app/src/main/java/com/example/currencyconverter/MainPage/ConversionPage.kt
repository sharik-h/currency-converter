package com.example.currencyconverter.MainPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun conversionPage() {

    var selectedFrom = remember { mutableStateOf("") }
    var selectedTo = remember { mutableStateOf("") }
    var amount = remember { mutableStateOf("0.00") }
    var exchValue = remember { mutableStateOf("0.00") }

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
            text = exchValue.value,
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
            value = amount.value,
            onValueChange = { amount.value = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(Modifier.fillMaxWidth()) {
            CurrencySelector(
                modifier = Modifier.weight(0.5f),
                fromOrTo = "From",
                selectedValue = { selectedFrom.value = it }
            )
            CurrencySelector(
                modifier = Modifier.weight(0.5f),
                fromOrTo = "To",
                selectedValue = { selectedTo.value = it },
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "CONVERT", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }

}