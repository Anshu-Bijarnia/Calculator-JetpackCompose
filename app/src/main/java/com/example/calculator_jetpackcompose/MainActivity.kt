package com.example.calculator_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<CalculatorViewModel>()
            val state = viewModel.state
            AppTheme {
                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = 12.dp,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}