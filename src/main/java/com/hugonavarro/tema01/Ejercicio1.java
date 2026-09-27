package com.hugonavarro.tema01;

import java.io.File;

public class Ejercicio1 {
    static void main() {
        File archivo = new File("/home/usuario/ADtema01");
        if (archivo.exists()) {
            IO.println("El fichero existe.");
        } else {
            IO.println("El fichero no existe.");
        }
        if (archivo.isDirectory()) {
            IO.println("El fichero es un directorio.");
        } else {
            IO.println("El fichero no es un directorio");
        }
    }
}
