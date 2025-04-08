package org.example.ui

interface IConsola {
    fun mostrar(msj: String)
    fun mostrarError(msj: String)
    fun pedirInfo(msj: String = ""): String
}