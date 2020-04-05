/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.BufferedReader;
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
    
    public Archivo() {
    }
    
 // metodo por el cual se lee el archivo y se convierte en una cadena de caracteres
    public String leerTxt(String direccion){
        String texto = "";//---> variable que almacenara los datos en una linea de texto 
        
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));//--->recorre el ciclo mientras haya datos 
            String temp= "";
            String bfread;
            while ((bfread = bf.readLine()) != null){
                temp = temp + bfread+" ";
                
            }
            texto = temp;
            
        } catch (IOException e) {
            System.out.println("No se encontro archivo");
        }
        return texto;
    }
} 
 
    
       
                    
                    
               
               
           
        
        
        
        
  



    

