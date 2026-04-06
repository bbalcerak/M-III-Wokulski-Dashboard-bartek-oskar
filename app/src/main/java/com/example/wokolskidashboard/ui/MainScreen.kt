package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.ExpenseForm

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>() }

    Column(modifier = modifier) {
        val balance = transactions.sumOf { if (it.isExpense) -it.amount else it.amount }

        Text(text = "Saldo: $balance rubli", modifier = Modifier.padding(16.dp))

        ExpenseForm(onAddExpense = { newTransaction ->
            transactions.add(newTransaction)
        })

        Text(text = "Ostatnie zapisy:")
        LazyColumn {
            items(transactions.size) { index ->
                val item = transactions[index]

                Text("- ${item.name}: ${item.amount} rubli (${item.category})")
            }
        }
    }
}