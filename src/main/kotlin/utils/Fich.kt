package org.example.utils

import org.example.ui.IConsola
import java.io.File

class Fich(private val ui: IConsola) : IUtilsFiles {
    /**
     * Lee el contenido de un archivo y devuelve una lista de líneas tipo String.
     *
     * @param ruta La ruta del archivo que se desea leer.
     * @return Una lista de cadenas que representan las líneas del archivo.
     * @throws IllegalArgumentException Si el archivo no existe.
     */
    override fun leerArchivo(ruta: String): List<String> {
        if (!existeFichero(ruta)) {
            throw IllegalArgumentException("*ERROR* El archivo no existe.")
        }
        val rutaArchivo = File(ruta)
        return rutaArchivo.readLines()
    }

    /**
     * Agrega una línea al final de un archivo existente.
     *
     * @param ruta La ruta del archivo al que se le desea agregar la línea.
     * @param linea La línea que se desea agregar al archivo.
     * @return true si la línea se agregó correctamente, false en caso contrario (si el archivo no existe).
     */
    override fun agregarLinea(ruta: String, linea: String): Boolean {
        if (!existeFichero(ruta)) {
            return false
        } else {
            val file = File(ruta)
            if (file.length().toInt() == 0) {
                file.appendText(linea)
            } else {
                file.appendText("\n" + linea)
            }
            return true
        }
    }

    /**
     * Escribe una lista de elementos en un archivo (vaciando previamente su contenido).
     *
     * @param ruta La ruta del archivo donde se desea escribir.
     * @param elementos Lista de elementos que implementan la interfaz IExportable,
     *                  que serán serializados y escritos en el archivo.
     * @return true si la operación se realizó con éxito.
     */
    override fun escribirArchivo(ruta: String, elementos: List<String>): Boolean {
        if (existeFichero(ruta)) {
            File(ruta).writeText("")

            for (elemento in elementos) {
                agregarLinea(ruta, elemento)
            }
            return true
        }
        return false
    }

    /**
     * Verifica si un archivo existe en la ruta especificada por parámetro.
     *
     * @param ruta La ruta del archivo que se desea verificar.
     * @return true si el archivo existe, false en caso contrario.
     */
    override fun existeFichero(ruta: String): Boolean {
        return File(ruta).isFile
    }

    /**
     * Verifica si un directorio existe en la ruta especificada por parámetro.
     *
     * @param ruta La ruta del directorio que se desea verificar.
     * @return true si el directorio existe, false en caso contrario.
     */
    override fun existeDirectorio(ruta: String): Boolean {
        return File(ruta).isDirectory
    }
}