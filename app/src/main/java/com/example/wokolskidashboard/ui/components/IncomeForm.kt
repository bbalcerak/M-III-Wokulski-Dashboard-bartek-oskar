package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(onSubmit: (product: String, price: Float) -> Unit) {
    val product = remember { mutableStateOf("") }
    val price = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Dodaj przychód", fontSize = MaterialTheme.typography.headlineMedium.fontSize)

        Text(text = "Nazwa produktu: ")
        OutlinedTextField(
            value = product.value,
            onValueChange = { product.value = it },
            label = { Text("Nazwa produktu") },
            placeholder = { Text(text = "Nazwa produktu") },
            modifier = Modifier.width(200.dp),

            singleLine = true
        )

        Text(text = "Cena produktu: ")
        OutlinedTextField(
            value = price.value,
            onValueChange = { price.value = it },
            label = { Text("Cena") },
            modifier = Modifier.width(200.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.height(8.dp))
        
    }
}