package com.example.calculator_jetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(modifier = Modifier
        .clickable {
            onClick()
        }
        .then(modifier), contentAlignment = Alignment.Center) {
        Text(
            text = symbol,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 45.sp,
            textAlign = TextAlign.Center
        )
    }
}