package com.hugonavarro.tema01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio8 {
    static void main(String[] args) {
        if (args.length == 0) {
            IO.println("ERROR: Por favor, especifique la ruta del archivo.");
        }

        String rutaArchivo = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            IO.println("--- Contenido de: " + rutaArchivo + " ---");
            while ((linea = br.readLine()) != null) {
                IO.println(linea);
            }
        } catch (IOException ioe) {
            IO.println("Error al leer el archivo: " + ioe.getMessage());
        }
    }
}
