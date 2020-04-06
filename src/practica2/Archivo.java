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
 * @author Jacobo pulgarin
 */
public class Archivo {

    public static void main(String[] args) throws IOException {

        String text1;
        String text2;

        // Cargamos el buffer con el contenido del archivo
        FileReader archivo = new FileReader("Archivo.txt");
        //pasamos el archivo buffer al bufferReader
        BufferedReader bufferArchivo = new BufferedReader(archivo);

        // Aqui se lee la primera linea del archivo, si se quiere leer otra linea se copia
        // y pega el mismo codigo debajo(supongo que se puede hacer con un For)
        text1 = bufferArchivo.readLine();

        System.out.println("La linea del archivo es: " + text1);
        System.out.println("La linea tiene " + text1.length() + " caracteres");

        System.out.println();
        System.out.println("Separando la linea en trozos tenemos las siguientes palabras:");
        System.out.println();

        int numTokens = 0;

        //Recibe un String en este caso text1 y el delimitador o separador de palabras que es la coma "," 
        StringTokenizer tokenizadorDePalabras = new StringTokenizer(text1, ",");

        // Ciclo para extraer las palabras de la linea separadas por ","
        while (tokenizadorDePalabras.hasMoreTokens()) {
            //lleva la palabra o token a la variable text2
            text2 = tokenizadorDePalabras.nextToken();
            numTokens++;
            System.out.println("    Palabra " + numTokens + " es: " + text2);
        }

    }
}
