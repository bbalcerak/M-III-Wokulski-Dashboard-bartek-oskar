package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm // IMPORT NOWEGO FORMULARZA

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val transactions = remember { mutableStateListOf<Transaction>() }

    Column(modifier = modifier) {
        val balance = transactions.sumOf { if (it.isExpense) -it.amount else it.amount }

        BalanceHeader(balance = balance)

        IncomeForm(onAddIncome = { newTransaction ->
            transactions.add(newTransaction)
        })

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        ExpenseForm(onAddExpense = { newTransaction ->
            transactions.add(newTransaction)
        })

        Text(
            text = "HISTORIA KSIĘGI: ",
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(transactions) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item.name)


                    val color = if (item.isExpense) Color.Red else Color(0xFF2E7D32)
                    val prefix = if (item.isExpense) "-" else "+"

                    Text(
                        text = "$prefix${item.amount} rub",
                        color = color,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}