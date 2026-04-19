package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.*

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>() }
    val balance = transactions.sumOf { if (it.isExpense) -it.amount else it.amount }

    Column(modifier = modifier.fillMaxSize()) {
        BalanceHeader(balance = balance)

        IncomeForm(onAddIncome = { transactions.add(it) })

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        ExpenseForm(onAddExpense = { transactions.add(it) })

        Text(
            text = "HISTORIA KSIĘGI:",
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(transactions) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item.name)
                    val color = if (item.isExpense) Color.Red else Color(0xFF2E7D32)
                    Text(
                        text = "${if (item.isExpense) "-" else "+"}${item.amount} rub",
                        color = color,
                        fontWeight = FontWeight.Bold
                    )
                }
                HorizontalDivider()
            }
        }
    }
}