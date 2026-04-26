package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddIncome:
                   (Transaction) -> Unit) {
    var name by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }
    var category by remember {
        mutableStateOf("")
    }

    Column(
        Modifier.padding(16.dp)
    ) {
        Text("KSIĘGOWANIE ZYSKÓW",
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        WokulskiTextField(value = name,
            onValueChange = { name = it },
            label = "Nazwa produktu")
        WokulskiTextField(value = amount,
            onValueChange = { amount = it },
            label = "Kwota (ruble)")
        WokulskiTextField(value = category,
            onValueChange = { category = it },
            label = "Kategoria")

        Spacer(modifier = Modifier.height(10.dp))

        WokulskiButton(
            text = "Zaksięguj zysk",
            onClick = {
                val parsedAmount = amount.toDoubleOrNull()

                if (name.isNotBlank() && parsedAmount != null && parsedAmount > 0) {
                    onAddIncome(
                        Transaction(
                            name,
                            parsedAmount,
                            false,
                            category,
                            false)
                    )
                    name = ""
                    amount = ""
                    category = ""
                }
            }
        )
    }
}