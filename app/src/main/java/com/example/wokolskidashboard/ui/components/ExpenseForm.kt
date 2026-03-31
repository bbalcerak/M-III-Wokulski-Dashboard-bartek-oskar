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


}