package com.example.calculator_jetpackcompose

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operator: CalculatorOperator? = null
)
