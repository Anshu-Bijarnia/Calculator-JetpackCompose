package com.example.calculator_jetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.calculate -> calculateSolution()
            is CalculatorAction.clear -> state = CalculatorState()
            is CalculatorAction.decimal -> insertDecimal()
            is CalculatorAction.delete -> implementDelete()
            is CalculatorAction.number -> insertNumber(action.number)
            is CalculatorAction.operator -> insertOperator(action.operator)

        }
    }

    private fun insertOperator(operator: CalculatorOperator) {
        if (state.number1.isNotBlank() && state.number2.isNotBlank()) {
            var number1 = state.number1.toDouble()
            var number2 = state.number2.toDouble()
            var result = when (state.operator) {
                CalculatorOperator.Add -> number1 + number2
                CalculatorOperator.Divide -> number1 / number2
                CalculatorOperator.Multiply -> number1 * number2
                CalculatorOperator.Percentage -> number1 * (number2 / 100.0)
                CalculatorOperator.Subtract -> number1 - number2
                null -> return
            }
            if (result.toInt() > result || result.toInt() < result) {
                state = state.copy(
                    number1 = result.toString().take(15),
                    operator = operator,
                    number2 = ""
                )
            } else {
                state = state.copy(
                    number1 = result.toInt().toString().take(15),
                    operator = operator,
                    number2 = ""
                )
            }
        } else if (state.number1.isNotBlank() && state.number1.toDouble() > 0.0) {
            state = state.copy(operator = operator)
        } else {
            return
        }
    }

    private fun insertNumber(number: Int) {
        if (state.operator == null) {
            if (state.number1.length >= 8) {
                return
            }
            state = state.copy(number1 = state.number1 + number)
            return
        } else {
            if (state.number2.length >= 8) {
                return
            }
            state = state.copy(number2 = state.number2 + number)
            return
        }
    }

    private fun insertDecimal() {
        state = if (state.number2.isNotEmpty() && !state.number2.contains(".")) {
            state.copy(number2 = state.number2 + ".")
        } else if (state.operator != null) {
            state.copy(number2 = "0.")
        } else if (state.number1.isNotEmpty() && !state.number1.contains(".")) {
            state.copy(number1 = state.number1 + ".")
        } else if (!state.number1.contains(".")) {
            state.copy(number1 = "0.")
        } else {
            return
        }
    }

    private fun implementDelete() {
        if (state.number2.isNotEmpty()) {
            state = state.copy(number2 = state.number2.dropLast(1))
        } else if (state.operator != null) {
            state = state.copy(operator = null)
        } else if (state.number1.isNotEmpty()) {
            state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun calculateSolution() {
        if (state.operator != null) {
            if (state.number2.isNotBlank()) {
                var number1 = state.number1.toDouble()
                var number2 = state.number2.toDouble()
                var result = when (state.operator) {
                    CalculatorOperator.Add -> number1 + number2
                    CalculatorOperator.Divide -> number1 / number2
                    CalculatorOperator.Multiply -> number1 * number2
                    CalculatorOperator.Percentage -> number1 * (number2 / 100.0)
                    CalculatorOperator.Subtract -> number1 - number2
                    null -> return
                }
                if (result.toInt() > result || result.toInt() < result) {
                    state = state.copy(
                        number1 = result.toString().take(15),
                        operator = null,
                        number2 = ""
                    )
                } else {
                    state = state.copy(
                        number1 = result.toInt().toString().take(15),
                        operator = null,
                        number2 = ""
                    )
                }
            } else {
                state = state.copy(operator = null)
            }
        } else {
            return
        }
    }
}