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
public class ArbolNarioListaGerneralizada {
    
    NodoNario raiz;

    public ArbolNarioListaGerneralizada(NodoNario raiz) {
        this.raiz = raiz;
    }
    
    public void Insertar (FileReader archivo) throws IOException{
        
        String text1;
        String text2;
        BufferedReader bufferArchivo = new BufferedReader(archivo);
        text1 = bufferArchivo.readLine();
        int numTokens = 0;
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
    
    
}
