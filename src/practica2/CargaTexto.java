/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author CompucenterPC1
 */
public class CargaTexto {

    public CargaTexto() {
    }
    
    
    
  public void leer(ArbolNarioListaGeneralizada lista) throws FileNotFoundException, IOException{
      
        String text1;
        String text2;

        // Cargamos el buffer con el contenido del archivo
        FileReader archivo = new FileReader("Archivo.txt");
        //pasamos el archivo buffer al bufferReader
        BufferedReader bufferArchivo = new BufferedReader(archivo);

        // Aqui se lee la primera linea del archivo, si se quiere leer otra linea se copia
        // y pega el mismo codigo debajo(supongo que se puede hacer con un For)
        text1 = bufferArchivo.readLine();

        //Recibe un String en este caso text1 y el delimitador o separador de palabras que es la coma "," 
        StringTokenizer tokenizadorDePalabras = new StringTokenizer(text1, ",");
        String nombre = "";
        String id = "";
        String padre = "";
        int cont = 0;
        
        // Ciclo para extraer las palabras de la linea separadas por ","
        while (tokenizadorDePalabras.hasMoreTokens()) {
            //lleva la palabra o token a la variable text2
            text2 = tokenizadorDePalabras.nextToken();
            if(cont == 0){
                id = text2;
            }
            if(cont == 1){
                nombre = text2;
            }
            if(cont == 2){
                padre = text2;
            }
            cont ++;

            if (!tokenizadorDePalabras.hasMoreTokens()) {
            text1 = bufferArchivo.readLine();
            Persona a = new Persona();
            a.setId(id);a.setNombre(nombre);a.setPadre(padre);
            lista.addPersona(a);
            id = "";nombre = "";padre = "";
            
            cont=0;
            if (text1 != null) {
                tokenizadorDePalabras = new StringTokenizer(text1, ",");
            cont=0;
            }
        }
        
        }
        

        }
  }
    