package org.example.service

import org.example.model.ICalculadora
import org.example.model.Operadores

class ServicioOperacion(private val calculadora: ICalculadora) {

    fun ejecutarOperacion(num1: Double, operadorStr: String, num2: Double): Pair<String, Double> {
        val operador = when (operadorStr) {
            "+" -> Operadores.SUMA
            "-" -> Operadores.RESTA
            "*" -> Operadores.MULTIPLICACION
            "/" -> {
                if (num2 == 0.0) throw ArithmeticException("No se puede dividir entre cero")
                Operadores.DIVISION
            }
            else -> throw IllegalArgumentException("Operador no válido: $operadorStr")
        }

        val resultado = calculadora.realizarCalculo(operador, num1, num2)
        val mensaje = "$num1 $operadorStr $num2 = $resultado"
        return mensaje to resultado
    }
}
