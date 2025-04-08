package org.example.model

interface ICalculadora {
    fun realizarCalculo(operador: Operadores, num: Double, num2: Double) : Double

    fun suma(num: Double, num2: Double): Double

    fun resta(num: Double, num2: Double): Double

    fun division(num: Double, num2: Double): Double

    fun multiplicacion(num: Double, num2: Double): Double
}