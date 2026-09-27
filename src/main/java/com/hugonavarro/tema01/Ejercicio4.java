package com.hugonavarro.tema01;

import java.io.File;

public class Ejercicio4 {
    static void main() {
        File archivo = new File("/home/usuario/ADtema01/ficheros/prueba.txt");
        if (archivo.exists()) {
            IO.println("Nombre del archivo dentro de la carpeta \"ficheros\": " + archivo.getName());
            IO.println("Ruta absoluta del archivo: " + archivo.getAbsolutePath());
            if (!archivo.isHidden()) {
                IO.println("El archivo no está oculto.");
            } else {
                IO.println("El archivo está oculto.");
            }
            if (archivo.canRead()) {
                IO.println("Esta carpeta se puede leer.");
            } else {
                IO.println("Esta carpeta no se puede leer.");
            }
            if (archivo.canWrite()) {
                IO.println("Esta carpeta se puede escribir.");
            } else {
                IO.println("Esta carpeta no se puede escribir.");
            }
            long bytes = archivo.length();
            double kilobytes = (double) bytes / 1024;
            double megabytes = (double) kilobytes / 1024;

            IO.println("Tamaño del archivo en Bytes: " + bytes + " B");
            IO.println("Tamaño del archivo en Kilobytes: " + String.format("%.2f", kilobytes) + " KB");
            IO.println("Tamaño del archivo en Megabytes: " + String.format("%.2f", megabytes) + " MB");
        } else {
            IO.println("El archivo no existe.");
        }
    }
}
