package org.example.utils


import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class GestorLog(private val ruta: String) : Ilog {

    private val formatoFechaArchivo  = SimpleDateFormat("yyyyMMddHHmmss")
    private val formatoFechaHoraRegistro   = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    private val archivoLog: File

    init {
        val carpeta = File(ruta)
        if (!carpeta.exists()) carpeta.mkdirs()
        val timestamp = formatoFechaArchivo .format(Date())
        archivoLog = File(carpeta, "log$timestamp.txt")
    }

    override fun registrarOperacion(mensaje: String) {
        val timestamp = formatoFechaHoraRegistro  .format(Date())
        archivoLog.appendText("$timestamp: $mensaje\n")
    }

    override fun mostrarContenidoLog() {
        if (archivoLog.exists()) {
            archivoLog.forEachLine { println(it) }
        } else {
            println("No se ha encontrado el archivo de log actual.")
        }
    }
}
