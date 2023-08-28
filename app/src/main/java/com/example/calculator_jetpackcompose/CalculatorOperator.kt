package com.example.calculator_jetpackcompose

sealed class CalculatorOperator(val symbol: String) {
    object Add : CalculatorOperator(symbol = "+")
    object Subtract : CalculatorOperator(symbol = "-")
    object Multiply : CalculatorOperator(symbol = "x")
    object Divide : CalculatorOperator(symbol = "÷")
    object Percentage : CalculatorOperator(symbol = "%")
}
