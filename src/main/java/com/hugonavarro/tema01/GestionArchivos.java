package com.hugonavarro.tema01;

import java.io.*;
import java.util.Scanner;

// Ejercicio 5
public class GestionArchivos {
    public static boolean crearArchivo(String directorio, String archivo) {
        try {
            File f = new File(directorio, archivo);
            boolean archivoCreado = f.createNewFile();
            if (archivoCreado) {
                IO.println("\nArchivo creado exitosamente");
                return true;
            } else {
                IO.println("\nEl archivo ya existe");
                return false;
            }
        } catch (IOException ioe) {
            IO.println("Error al crear el archivo: " + ioe.getMessage());
            return false;
        }
    }
    public static void listarDirectorio(String directorio) {
        File d = new File(directorio);
        if (!d.exists() || !d.isDirectory()) {
            IO.println("El directorio no es válido o no existe.");
            return;
        }

        File[] elementos = d.listFiles();
        if (elementos == null) {
            IO.println("Los elementos de un directorio no pueden ser null.");
        }
        assert elementos != null;

        for (File f : elementos) {
            String nombre = f.getName();
            String tipo = f.isDirectory() ? "d" : "f";
            long tamanyo = f.length();

            String permisos = "";
            if (f.canRead()) {
                permisos += "r";
            }
            if (f.canWrite()) {
                permisos += "w";
            }

            IO.println(nombre + " " + tipo + " " + tamanyo + " bytes " + permisos);
        }
    }
    public static void verInfo(String directorio, String archivo) {
        File f = new File(directorio, archivo);
        if (f.exists()) {
            IO.println("\nNombre: " + f.getName());
            IO.println("Ruta absoluta: " + f.getAbsolutePath());

            boolean poderEscribir = f.canWrite();
            if (poderEscribir) {
                IO.println("Se puede escribir");
            } else {
                IO.println("No se puede escribir");
            }

            boolean poderLeer = f.canRead();
            if (poderLeer) {
                IO.println("Se puede leer");
            } else {
                IO.println("No se puede leer");
            }

            IO.println("Tamaño: " + f.length());

            boolean esDirectorio = f.isDirectory();
            if (esDirectorio) {
                IO.println("Es un directorio");
            } else {
                IO.println("No es un directorio");
            }

            boolean esArchivo = f.isFile();
            if (esArchivo) {
                IO.println("Es un archivo");
            } else {
                IO.println("No es un archivo");
            }
        } else {
            IO.println("\nEl archivo no existe");
        }
    }

    // Ejercicio 6
    public static void verContenidoDeUnArchivo(String directorio, String archivo) {
        File f = new File(directorio, archivo);
        if (f.exists()) {
            try (
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr)
            ){
                String linea = br.readLine();
                IO.println("\n" + linea);
            } catch (IOException ioe) {
                IO.println("\nFichero no encontrado");
            }
        } else {
            IO.println("\nEl archivo no existe");
        }
    }
    public static void mostrarMenu() {
        IO.println("\nMENÚ A ELEGIR");
        IO.println("--------------------");
        IO.println("1 - Crear un archivo");
        IO.println("2 - Visualizar el contenido del directorio");
        IO.println("3 - Visualizar información de un archivo");
        IO.println("4 - Mostrar contenido de un archivo");
        IO.println("5 - Salir");
        IO.print("\nElige una opción: ");
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearArchivo("/home/usuario/ADtema01/ficheros/", "archivo.txt");
                    break;
                case 2:
                    listarDirectorio("/home/usuario/ADtema01/ficheros/");
                    break;
                case 3:
                    verInfo("/home/usuario/ADtema01/ficheros/", "archivo.txt");
                    break;
                case 4:
                    verContenidoDeUnArchivo("/home/usuario/ADtema01/ficheros/", "archivo.txt");
                    break;
                case 5:
                    IO.println("\nSaliendo...");
                    break;
                default:
                    IO.println("\nOpción inválida");
                    break;
            }
        } while (opcion != 5);
        sc.close();
    }
}
