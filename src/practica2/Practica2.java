/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CompucenterPC1
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileReader entrada = new FileReader("I:\\Udea\\Logica y representacion 3\\Practica 2\\ArchivoBase.txt");
            Archivo a = new Archivo();
         //   System.out.println(a.dividirTxt(entrada));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Practica2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
