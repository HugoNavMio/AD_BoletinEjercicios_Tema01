package com.hugonavarro.tema01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio9 {
    public static boolean archivosIguales(String archivo1, String archivo2) {
        try (
                FileInputStream f1 = new FileInputStream(archivo1);
                FileInputStream f2 = new FileInputStream(archivo2)
        ) {
            int byte1;
            int byte2;

            while ((byte1 = f1.read()) != -1 && (byte2 = f2.read()) != -1) {
                if (byte1 != byte2) {
                    return false;
                }
            }

            return f1.read() == -1 && f2.read() == -1;
        } catch (IOException ioe) {
            IO.println("Error al leer los archivos: " + ioe.getMessage());
            return false;
        }
    }

    static void main() {
        String archivo1 = "/home/usuario/ADtema01/comprobarFicherosIguales/f1.txt";
        String archivo2 = "/home/usuario/ADtema01/comprobarFicherosIguales/f2.txt";

        if (archivosIguales(archivo1, archivo2)) {
            IO.println("Los archivos son iguales.");
        } else {
            IO.println("Los archivos son diferentes.");
        }
    }
}
