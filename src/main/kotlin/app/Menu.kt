package org.example

import org.example.model.Calculadora
import org.example.model.ICalculadora
import org.example.model.Operadores
import org.example.ui.Consola
import org.example.ui.IConsola

class Menu(private val consola: IConsola, private val calculadora: ICalculadora) {

    fun ejecutarMenu() {
        consola.mostrar("----- CALCULADORA BÁSICA -----")
        do {
            try {
                val num1 = consola.pedirInfo("Introduce el primer número: ").toDouble()
                val num2 = consola.pedirInfo("Introduce el segundo número: ").toDouble()
                val operadorRecibido = consola.pedirInfo("Introduce el operador (+, -, *, /): ")

                val operador = when (operadorRecibido) {
                    "+" -> Operadores.SUMA
                    "-" -> Operadores.RESTA
                    "*" -> Operadores.MULTIPLICACION
                    "/" -> {
                        if (num2 == 0.0) throw ArithmeticException("No se puede dividir entre cero")
                        Operadores.DIVISION
                    }
                    else -> throw IllegalArgumentException("Operador no válido")
                }

                val resultado = calculadora.realizarCalculo(operador, num1, num2)
                consola.mostrar("Resultado: $resultado")

            } catch (e: NumberFormatException) {
                consola.mostrarError("Error: Formato de número incorrecto")
            }

        } while (consola.pedirInfo("¿Desea realizar otro cálculo? (s/n)").lowercase() == "s")
    }
}
