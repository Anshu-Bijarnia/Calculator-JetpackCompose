package com.example.calculator_jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operator?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                maxLines = 2,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                fontSize = 60.sp,
                lineHeight = 64.sp
            )
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(top = 25.dp, bottom = 25.dp, end = 15.dp),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "AC",
                        onClick = { onAction(CalculatorAction.clear) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "⌫",
                        onClick = { onAction(CalculatorAction.delete) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "%",
                        onClick = { onAction(CalculatorAction.operator(CalculatorOperator.Percentage)) })
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                        symbol = "÷",
                        onClick = { onAction(CalculatorAction.operator(CalculatorOperator.Divide)) })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "7",
                        onClick = { onAction(CalculatorAction.number(7)) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "8",
                        onClick = { onAction(CalculatorAction.number(8)) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "9",
                        onClick = { onAction(CalculatorAction.number(9)) })
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                        symbol = "x",
                        onClick = { onAction(CalculatorAction.operator(CalculatorOperator.Multiply)) })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "4",
                        onClick = { onAction(CalculatorAction.number(4)) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "5",
                        onClick = { onAction(CalculatorAction.number(5)) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "6",
                        onClick = { onAction(CalculatorAction.number(6)) })
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                        symbol = "-",
                        onClick = { onAction(CalculatorAction.operator(CalculatorOperator.Subtract)) })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "1",
                        onClick = { onAction(CalculatorAction.number(1)) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "2",
                        onClick = { onAction(CalculatorAction.number(2)) })
                    CalculatorButton(
                        modifier = Modifier.weight(1f),
                        symbol = "3",
                        onClick = { onAction(CalculatorAction.number(3)) })
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.tertiaryContainer),
                        symbol = "+",
                        onClick = { onAction(CalculatorAction.operator(CalculatorOperator.Add)) })
                }
                Row(horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        symbol = "0",
                        onClick = { onAction(CalculatorAction.number(0)) })
                    CalculatorButton(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        symbol = ".",
                        onClick = { onAction(CalculatorAction.decimal) })
                    CalculatorButton(
                        modifier = Modifier
                            .weight(2f)
                            .aspectRatio(2f)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        symbol = "=",
                        onClick = { onAction(CalculatorAction.calculate) })
                }
            }
        }
    }
}
