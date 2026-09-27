package com.hugonavarro.tema01;

import java.io.File;

public class Ejercicio2 {
    static void main() {
        File carpeta = new File("/home/usuario/ADtema01");
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isDirectory()) {
                        IO.println("[D] " + archivo.getName());
                    } else {
                        IO.println("[F] " + archivo.getName());
                    }
                }
            } else {
                IO.println("La ruta no es válida o no existe.");
            }
        }
    }
}
