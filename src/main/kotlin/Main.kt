package org.example

import org.example.app.Menu
import org.example.model.Calculadora
import org.example.model.Operadores
import org.example.service.ServicioOperacion
import org.example.ui.Consola
import org.example.ui.IConsola
import org.example.utils.Fich
import org.example.utils.GestorLog
import java.io.File


fun main(args: Array<String>) {
    val consola: IConsola = Consola()
    val fich = Fich()
    val calculadora = Calculadora()
    val servicioOperacion = ServicioOperacion(calculadora)

    when (args.size) {
        0 -> {
            val ruta = "./log"
            val gestorLog = GestorLog(ruta)
            gestionarYMostrarLog(ruta, consola, fich, gestorLog)

            val menu = Menu(consola, calculadora, gestorLog)
            menu.ejecutarMenu()
        }

        1 -> {
            val ruta = args[0]
            val gestorLog = GestorLog(ruta)
            gestionarYMostrarLog(ruta, consola, fich, gestorLog)

            val menu = Menu(consola, calculadora, gestorLog)
            menu.ejecutarMenu()
        }

        4 -> {
            val ruta = args[0]
            val num1 = args[1].toDouble()
            val operador = args[2]
            val num2 = args[3].toDouble()
            val log = GestorLog(ruta)

            try {
                val (mensaje, _) = servicioOperacion.ejecutarOperacion(num1, operador, num2)
                println(mensaje)
                log.registrarOperacion(mensaje)
            } catch (e: Exception) {
                val error = "Error: ${e.message}"
                println(error)
                log.registrarOperacion(error)
            }
        }

        else -> {
            consola.mostrarError("Número de argumentos inválido. El programa no se iniciará.")
        }
    }
}

fun gestionarYMostrarLog(ruta: String, consola: IConsola, fich: Fich, gestorLog: GestorLog) {
    if (fich.crearCarpetaSiNoExiste(ruta)) {
        consola.mostrar("Ruta $ruta creada")
    }

    val log = fich.obtenerLogMasReciente(ruta)
    if (log != null) {
        consola.mostrar("Mostrando log más reciente:")
        log.forEachLine { consola.mostrar(it) }
    } else {
        consola.mostrar("No existen ficheros de Log")
    }

    consola.pedirInfo("Pulsa ENTER para continuar...")
    limpiarPantalla()
}

fun limpiarPantalla() {
    print("\u001b[H\u001b[2J")
    System.out.flush()
}
