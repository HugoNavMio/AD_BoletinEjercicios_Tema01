package com.hugonavarro.tema01;

import java.io.File;

public class Ejercicio3 {
    static void main() {
        File carpeta = new File("/home/usuario/ADtema01");
        if (carpeta.exists()) {
            IO.println("Nombre de la carpeta: " + carpeta.getName());
            IO.println("Ruta absoluta de la carpeta: " + carpeta.getAbsolutePath());
            if (carpeta.canRead()) {
                IO.println("Esta carpeta se puede leer.");
            } else {
                IO.println("Esta carpeta no se puede leer.");
            }
            if (carpeta.canWrite()) {
                IO.println("Esta carpeta se puede escribir.");
            } else {
                IO.println("Esta carpeta no se puede escribir.");
            }
        } else {
            IO.println("La carpeta no existe.");
        }
    }
}
