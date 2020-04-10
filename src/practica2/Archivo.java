/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.*;
import java.util.*;

/**
 *
 * @author Esneider
 */
public class Archivo {
    
    String prueba="papa";

   public static void main(String[] args) throws IOException {
       
       
        String text1;
        String text2;

        // ---> Cargamos el buffer con el contenido del archivo
        FileReader archivo = new FileReader("Archivo.txt");
        
        
        // ---> usado para el emtodo que cuenta palabras y lineas
        //File archivo1 = new File("Archivo1.txt");
        //contarPalabrasLineas(archivo1);

        // ---> convertimos un archivo File a un FileReader
        //Reader archivo2 = new FileReader(archivo1);
        
        
        // ---> pasamos el archivo buffer al bufferReader
        BufferedReader bufferArchivo = new BufferedReader(archivo);

        // ---> Aqui se lee la primera linea del archivo, si se quiere leer otra linea se copia
        // ---> y pega el mismo codigo debajo(supongo que se puede hacer con un For)
        text1 = bufferArchivo.readLine();

        System.out.println("La linea del archivo es: " + text1);
        System.out.println("La linea tiene " + text1.length() + " caracteres");

        System.out.println();
        System.out.println("Separando la linea en trozos tenemos las siguientes palabras:");
        System.out.println();

        int numTokens = 0;

        // ---> Recibe un String en este caso text1 y el delimitador o separador de palabras que es la coma "," 
        StringTokenizer tokenizadorDePalabras = new StringTokenizer(text1, ",");

        // ---> Ciclo para extraer las palabras de la linea separadas por ","
        while (tokenizadorDePalabras.hasMoreTokens()) {
            // ---> lleva la palabra o token a la variable text2
            text2 = tokenizadorDePalabras.nextToken();
            numTokens++;
            System.out.println("    La palabra " + numTokens + " es: " + text2);
            
            if (!tokenizadorDePalabras.hasMoreTokens()) {
            text1 = bufferArchivo.readLine();
            if (text1 != null) {
                tokenizadorDePalabras = new StringTokenizer(text1, ",");
            }
        }
        }
   
    }

    public static void contarPalabrasLineas(File archivo) {

        int palabrasTotales = 0;
        int lineasTotales = 0;

        try {
            // SI EXISTE EL ARCHIVO
            if (archivo.exists()) {
                try ( // ABRE LECTURA
                        BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo))) {
                    String lineaLeida;
                    // MIENTRAS LA LINEA LEIDA NO SEA NULL
                    while ((lineaLeida = archivoLeer.readLine()) != null) {
                        System.out.println(lineaLeida);
                        
                        // CONTAMOS LAS PALABRAS DE LA LINEA
                        StringTokenizer st = new StringTokenizer(lineaLeida);
                        
                        // AUMENTA EL CONTADOR DE LINEAS Y DE PALABRAS
                        lineasTotales = lineasTotales + 1;
                        palabrasTotales = palabrasTotales + st.countTokens();
                    }   System.out.println("");
                    System.out.println("Numero de palabras: " + palabrasTotales);
                    System.out.println("Lineas totales: " + lineasTotales);
                    // CIERRA LA LECTURA
                }
            } else {
                System.out.println("NO EXISTE EL ARCHIVO");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
