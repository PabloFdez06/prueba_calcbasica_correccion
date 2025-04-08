package org.example.utils

interface IUtilsFiles {
    fun leerArchivo(ruta: String): List<String>
    fun agregarLinea(ruta: String, linea: String): Boolean
    fun escribirArchivo(ruta: String, elementos: List<String>): Boolean
    fun existeFichero(ruta: String): Boolean
    fun existeDirectorio(ruta: String): Boolean
}