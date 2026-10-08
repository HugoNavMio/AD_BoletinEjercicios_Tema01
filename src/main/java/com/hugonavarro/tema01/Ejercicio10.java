package com.hugonavarro.tema01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio10 {
    public static void concat(String archivo1, String archivo2, String archivoDestino) {
        try (
                FileInputStream f1 = new FileInputStream(archivo1);
                FileInputStream f2 = new FileInputStream(archivo2);
                FileOutputStream destino = new FileOutputStream(archivoDestino)
        ) {
            int dato;

            while ((dato = f1.read()) != -1) {
                destino.write(dato);
            }

            while ((dato = f2.read()) != -1) {
                destino.write(dato);
            }

            IO.println("Archivos concatenados correctamente.");
        } catch (IOException ioe) {
            IO.println("Error al concatenar los archivos: " + ioe.getMessage());
        }
    }

    static void main() {
        String archivo1 = "/home/usuario/ADtema01/concatenarDosFicheros/f1.txt";
        String archivo2 = "/home/usuario/ADtema01/concatenarDosFicheros/f2.txt";
        String archivoDestino = "/home/usuario/ADtema01/concatenarDosFicheros/resultado.txt";

        concat(archivo1, archivo2, archivoDestino);
    }
}
