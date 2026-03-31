package com.example.wokolskidashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.theme.WokolskiDashBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WokolskiDashBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier) {


    BalanceHeader(balance = 14.00f)

    IncomeForm(onSubmit = { product, price ->
        println("Sold: $product for $$price")
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WokolskiDashBoardTheme {
        Main(modifier = Modifier)
    }
}