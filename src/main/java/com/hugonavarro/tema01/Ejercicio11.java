package com.hugonavarro.tema01;

import java.io.*;

public class Ejercicio11 {
    public static void concatLines(String archivo1, String archivo2, String archivoDestino) {
        try (
                BufferedReader f1 = new BufferedReader(new FileReader(archivo1));
                BufferedReader f2 = new BufferedReader(new FileReader(archivo2));
                BufferedWriter destino = new BufferedWriter(new FileWriter(archivoDestino))
        ) {
            String linea1;
            String linea2;

            while ((linea1 = f1.readLine()) != null && (linea2 = f2.readLine()) != null) {
                destino.write(linea1 + linea2);
                destino.newLine();
            }

            IO.println("Archivos concatenados correctamente.");
        } catch (IOException ioe) {
            IO.println("Error al concatenar los archivos: " + ioe.getMessage());
        }
    }

    static void main() {
        String archivo1 = "/home/usuario/ADtema01/concatenarLineasDeDosFicheros/f1.txt";
        String archivo2 = "/home/usuario/ADtema01/concatenarLineasDeDosFicheros/f2.txt";
        String archivoDestino = "/home/usuario/ADtema01/concatenarLineasDeDosFicheros/resultado.txt";

        concatLines(archivo1, archivo2, archivoDestino);
    }
}
