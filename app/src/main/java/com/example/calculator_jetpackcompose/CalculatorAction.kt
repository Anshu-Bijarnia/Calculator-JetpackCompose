package com.example.calculator_jetpackcompose

sealed class CalculatorAction {
    data class number(val number: Int) : CalculatorAction()
    object clear : CalculatorAction()
    object delete : CalculatorAction()
    data class operator(val operator: CalculatorOperator) : CalculatorAction()
    object calculate : CalculatorAction()
    object decimal : CalculatorAction()
}