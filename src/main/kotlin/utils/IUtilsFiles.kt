package org.example.utils

import java.io.File

interface IUtilsFiles {
    fun crearCarpetaSiNoExiste(path: String): Boolean
    fun obtenerLogs(path: String): List<File>
    fun obtenerLogMasReciente(path: String): File?
}