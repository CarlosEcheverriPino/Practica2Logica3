/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;


import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacobo pulgarin
 */
public class Archivo {
    
    // estos arreglos almacenara los valores de las matrices y de las tripletas
    int valores[];
    
public String leerTxt(String direccion){
    String texto  = "";
    try {
        BufferedReader bf = new BufferedReader(new FileReader(direccion));//--> Se inicializa la clase BufferReader y se 
        String temp = "";                                                 //le enviar ruta destino del archivo.
        String bfRead;
        while((bfRead = bf.readLine()) != null){                          //-->Recorre el ciclo mientras tenga datos
            temp = temp + bfRead;                                         //-->Concatenamos los datos.  
        }
        texto = temp;                                                     //-->Cambiamos a la variable principal.  
        
    } catch (Exception e) {
        System.out.println("No se encontro archivo");
    }
    return texto;
}

public StringBuilder dividirTxt(FileReader a){
    StringBuilder cadena = new StringBuilder();
    FileReader fr =a;
    String s;
    try {
        int valor = fr.read();
        String letra = "";
        valor = fr.read();
        while (valor != -1){
            char texto = (char)valor;
            cadena.append(texto);
            valor = fr.read();
        }
    } catch (Exception e) {
    }
    return cadena;
  
   
} 
 
    
}       
                    
                    
               
               
           
        
        
        
        
  



    

