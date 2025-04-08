package org.example

import org.example.model.Calculadora
import org.example.ui.Consola
import org.example.ui.IConsola
import org.example.utils.Fich
import java.io.File


fun main(args: Array<String>) {
    val ui: IConsola = Consola()

    when (args.size) {
        0 -> {

            val file = Fich(ui).existeDirectorio("./log")
            ui.mostrar("Ruta ./log creada")


        }
        1 -> {}
        4 -> {}
    }

    Menu(Consola(), Calculadora()).ejecutarMenu()

}