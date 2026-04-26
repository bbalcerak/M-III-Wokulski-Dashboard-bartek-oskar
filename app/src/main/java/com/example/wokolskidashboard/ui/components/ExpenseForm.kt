package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun ExpenseForm(onAddExpense:
                    (Transaction) -> Unit){
    var name by remember{
        mutableStateOf("")
    }
    var amount by remember{
        mutableStateOf("")
    }
    var category by remember{
        mutableStateOf("")
    }
    var isUnnecessary by remember{
        mutableStateOf(false)
    }

    Column(
        Modifier.padding(16.dp)
    ) {
        Text("KSIĘGOWANIE KOSZTÓW",
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        WokulskiTextField(value = name,
            onValueChange = { name = it },
            label = "Nazwa towaru/usługi")
        WokulskiTextField(value = amount,
            onValueChange = { amount = it },
            label = "kwota (ruble)")
        WokulskiTextField(value = category,
            onValueChange = { category = it },
            label = "Kategoria")

        Row(verticalAlignment = Alignment.CenterVertically){
            Text("Wydatek zbyteczny? ")
            Switch(checked = isUnnecessary, onCheckedChange = { isUnnecessary = it })
        }

        Spacer(modifier = Modifier.height(10.dp))

        WokulskiButton(
            text = "Dodaj do księgi",
            onClick = {
                val parsedAmount = amount.toDoubleOrNull()

                if(name.isNotBlank() && parsedAmount != null && parsedAmount > 0) {
                    val transaction = Transaction(
                        name = name,
                        amount = parsedAmount,
                        isExpense = true,
                        category = category,
                        isUnnecessary = isUnnecessary
                    )

                    onAddExpense(transaction)
                    name = ""
                    amount = ""
                    category = ""
                    isUnnecessary = false
                }
            }
        )
    }
}