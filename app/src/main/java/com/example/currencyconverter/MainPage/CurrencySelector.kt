package com.example.currencyconverter.MainPage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconverter.utils.Currencies
import com.example.currencyconverter.R


// drop down UI that contain contry name and code
@Composable
fun CurrencySelector(
    modifier: Modifier,
    fromOrTo: String,
    selectedValue: (String) -> Unit
) {
    val selectState = remember { mutableStateOf(false) }
    val selectedValue1 = remember { mutableStateOf("") }
    val countries = Currencies().countries

    Column(modifier = Modifier
        .height(80.dp)
        .then(modifier)) {
        Text(text = fromOrTo)
        Box(
            modifier = Modifier
                .width(120.dp)
                .border(BorderStroke(1.dp, Color.Gray))
                .clickable { selectState.value = !selectState.value }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
                Text(text = selectedValue1.value, fontSize = 20.sp)
                Spacer(modifier = Modifier.weight(0.1f))
                Image(painter = painterResource(id = R.drawable.arrow_down_black), contentDescription = "")
                DropdownMenu(expanded = selectState.value, onDismissRequest = { selectState.value = false }) {
                    countries.forEach {
                        DropdownMenuItem(
                            text = { Text(text = "${it.key} - ${it.value}") },
                            onClick = {
                                selectedValue1.value = it.value
                                selectedValue(it.value)
                                selectState.value = false
                            }
                        )
                    }
                }
            }
        }
    }
}