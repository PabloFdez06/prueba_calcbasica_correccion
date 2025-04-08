package org.example.ui

import org.example.model.Calculadora
import org.example.model.Operadores
import java.util.*

class Consola: IConsola {

    val scanner = Scanner(System.`in`)


    override fun mostrar(msj: String) {
        println(msj)
    }

    override fun mostrarError(msj: String) {
        println(msj)
    }

    override fun pedirInfo(msj: String): String {
        if (msj.isNotEmpty()){
            mostrar(msj)
        }
        return scanner.nextLine()
    }

}