package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun IncomeForm(onAddIncome: (Transaction) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    Column(
        Modifier.padding(16.dp)
    ) {
        Text("KSIĘGOWANIE ZYSKÓW (PRZYCHODY)")

        WokulskiTextField(
            value = name,
            onValueChange = { name = it },
            label = "Nazwa produktu"
        )
        WokulskiTextField(
            value = amount,
            onValueChange = { amount = it },
            label = "Kwota (ruble)"
        )
        WokulskiTextField(
            value = category,
            onValueChange = { category = it },
            label = "Kategoria"
        )

        Spacer(modifier = Modifier.height(10.dp))

        WokulskiButton(
            text = "Zaksięguj zysk",
            onClick = {
                val parsedAmount = amount.toDoubleOrNull()

                if (name.isNotBlank() && parsedAmount != null && parsedAmount > 0) {
                    val transaction = Transaction(
                        name = name,
                        amount = parsedAmount,
                        isExpense = false,
                        category = category,
                        isUnnecessary = false
                    )

                    onAddIncome(transaction)
                    name = ""
                    amount = ""
                    category = ""
                }
            }
        )
    }
}