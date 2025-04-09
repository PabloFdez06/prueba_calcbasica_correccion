package org.example.utils

import org.example.ui.IConsola
import java.io.File

class Fich : IUtilsFiles {

    override fun crearCarpetaSiNoExiste(path: String): Boolean {
        val carpeta = File(path)
        return if (!carpeta.exists()) {
            carpeta.mkdirs()
        } else {
            false
        }
    }

    override fun obtenerLogs(path: String): List<File> {
        val carpeta = File(path)
        return carpeta.listFiles { file ->
            file.name.startsWith("log") && file.name.endsWith(".txt")
        }?.toList() ?: emptyList()
    }

    override fun obtenerLogMasReciente(path: String): File? {
        return obtenerLogs(path).maxByOrNull { it.lastModified() }
    }
}