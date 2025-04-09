package org.example.app

import org.example.model.ICalculadora
import org.example.service.ServicioOperacion
import org.example.ui.IConsola
import org.example.utils.Ilog

class Menu(
    private val consola: IConsola,
    calculadora: ICalculadora,
    private val log: Ilog
) {

    private val servicioOperacion = ServicioOperacion(calculadora)

    fun ejecutarMenu() {
        consola.mostrar("----- CALCULADORA BÁSICA -----")
        do {
            try {
                // Pedimos los números y el operador
                val num1 = consola.pedirInfo("Introduce el primer número: ").toDouble()
                val num2 = consola.pedirInfo("Introduce el segundo número: ").toDouble()
                val operadorRecibido = consola.pedirInfo("Introduce el operador (+, -, *, /): ")

                val resultado = servicioOperacion.ejecutarOperacion(num1, operadorRecibido, num2)

                val mensaje = resultado.first

                consola.mostrar("Resultado: $mensaje")
                log.registrarOperacion(mensaje)

            } catch (e: NumberFormatException) {
                val mensaje = "Error: Formato de número incorrecto"
                consola.mostrarError(mensaje)
                log.registrarOperacion(mensaje)
            } catch (e: ArithmeticException) {
                val mensaje = "Error: ${e.message}"
                consola.mostrarError(mensaje)
                log.registrarOperacion(mensaje)
            } catch (e: IllegalArgumentException) {
                val mensaje = "Error: ${e.message}"
                consola.mostrarError(mensaje)
                log.registrarOperacion(mensaje)
            }

        } while (consola.pedirInfo("¿Desea realizar otro cálculo? (s/n)").lowercase() == "s")
    }
}