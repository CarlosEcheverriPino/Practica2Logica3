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
    
   public void leer(ArbolNarioListaGeneralizada Lista) throws FileNotFoundException, IOException{
      
         Persona a = new Persona();
         Lista = new ArbolNarioListaGeneralizada();
      
        String text1;
        String text2;

        // Cargamos el buffer con el contenido del archivo
        FileReader archivo = new FileReader("C:\\Users\\user\\Desktop\\proyetos java\\Practica2Logica3\\Personas.txt");
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
                a.setId(id);
            }
            if(cont == 1){
                nombre = text2;
                a.setNombre(nombre);
            }
            if(cont == 2){
                padre = text2;
                a.setPadre(padre);
            }
            cont ++;
                        
            
            
            if (!tokenizadorDePalabras.hasMoreTokens()) {
            text1 = bufferArchivo.readLine();
            if (text1 != null) {
                tokenizadorDePalabras = new StringTokenizer(text1, ",");
                //System.out.println(a.getId()+a.getNombre()+ a.getPadre());
            cont=0;
            
            //Agrega las personas y las manda a el arbol
            //Per.setId(id);
            //Per.setNombre(nombre);
            //Per.setPadre(padre);
            Lista.addPersona(a);
            }
        }
        
        }
        

        }
  }
    


/*while (tokenizadorDePalabras.hasMoreTokens()) {
            //lleva la palabra o token a la variable text2
            text2 = tokenizadorDePalabras.nextToken();
            numTokens++;
            System.out.println("    La palabra " + numTokens + " es: " + text2);
            
            if (!tokenizadorDePalabras.hasMoreTokens()) {
            text1 = bufferArchivo.readLine();
            if (text1 != null) {
                tokenizadorDePalabras = new StringTokenizer(text1, ",");*/