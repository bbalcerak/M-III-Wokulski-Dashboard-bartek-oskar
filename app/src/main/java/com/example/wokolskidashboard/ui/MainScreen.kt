package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>() }
    val balance = transactions.sumOf { if (it.isExpense) -it.amount else it.amount }

    Column(modifier = modifier.fillMaxSize()) {
        BalanceHeader(balance = balance)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                IncomeForm(onAddIncome = { transactions.add(it) })
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                ExpenseForm(onAddExpense = { transactions.add(it) })

                Text(
                    text = "HISTORIA KSIĘGI:",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            items(transactions) { item ->
                TransactionRow(item)
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp)
            }
        }
    }
}

@Composable
fun TransactionRow(item: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = item.name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (item.category.isNotBlank()) {
                    Text(text = "[${item.category}] ", style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                }
                if (item.isExpense && item.isUnnecessary) {
                    Text(text = "ZBYTECZNY", style = MaterialTheme.typography.labelSmall, color = Color.Red, fontWeight = FontWeight.Bold)
                }
            }
        }
        val color = if (item.isExpense) Color.Red else Color(0xFF2E7D32)
        Text(text = "${if (item.isExpense) "-" else "+"}${item.amount} rub", color = color, fontWeight = FontWeight.Bold)
    }
}